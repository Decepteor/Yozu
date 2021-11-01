package com.jamie.yozu.dao.hibernate;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.jamie.yozu.domain.hibernate.MessageHibernate;
import com.jamie.yozu.domain.hibernate.TagHibernate;
import com.jamie.yozu.domain.hibernate.UserHibernate;

@Repository
public class MessageDaoHibernate extends BasicHibernateDao {
  
  public List<MessageHibernate> getAll() {
    return template.execute(action ->  {
      CriteriaBuilder cb = getSession().getCriteriaBuilder();
      CriteriaQuery<MessageHibernate> q = cb.createQuery(MessageHibernate.class);
      Root<MessageHibernate> root = q.from(MessageHibernate.class);
      List<MessageHibernate> list = getSession().createQuery(q.select(root).orderBy(cb.desc(root.get("lastUpdated"))))
          .setMaxResults(20).getResultList();
      for (MessageHibernate message : list) {
        message.init();
      }
      return list;
      });
  }

  public List<MessageHibernate> getAllMessagesContainingTags(List<TagHibernate> tags) {
    return  (List<MessageHibernate>) template.execute(action ->  {
      
      @SuppressWarnings("unchecked")
      List<MessageHibernate> list = (List<MessageHibernate>) getSession()
          .createQuery("from MessageHibernate as mess inner join fetch mess.tags as tags where tags in :tags order by mess.lastUpdated desc")
          .setParameter("tags", tags).setMaxResults(20).getResultList();
      for (MessageHibernate message : list) {
        message.init();
      }
      return list;
      });
  }
  
  public boolean isMessageWithTitleForUserInLast24Hours(String title, UserHibernate user) {
    return template.execute(action ->  {
      CriteriaBuilder cb = getSession().getCriteriaBuilder();
      CriteriaQuery<MessageHibernate> q = cb.createQuery(MessageHibernate.class);
      Root<MessageHibernate> root = q.from(MessageHibernate.class);
      q.where(cb.and(cb.equal(root.get("title"),title), 
              cb.equal(root.get("user"),user),
              cb.greaterThan(root.get("lastUpdated"), LocalDateTime.now().minusDays(1L))));
      return getSession().createQuery(q).setMaxResults(1).getResultList();
      }).size() > 0;
  }
  
}
