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
      return getSession().createQuery(q.select(root)).setMaxResults(20).getResultList();
      });
  }

  public List<MessageHibernate> getAllMessagesContainingTags(List<TagHibernate> tags) {
    return template.execute(action ->  {
      CriteriaBuilder cb = getSession().getCriteriaBuilder();
      CriteriaQuery<MessageHibernate> q = cb.createQuery(MessageHibernate.class);
      Root<MessageHibernate> root = q.from(MessageHibernate.class);
      q.where(root.get("tags").in(tags));
      List<MessageHibernate> list = getSession().createQuery(q).setMaxResults(20).getResultList();
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
