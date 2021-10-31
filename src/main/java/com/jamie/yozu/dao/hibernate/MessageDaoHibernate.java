package com.jamie.yozu.dao.hibernate;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.jamie.yozu.domain.hibernate.MessageHibernate;
import com.jamie.yozu.domain.hibernate.TagHibernate;

public class MessageDaoHibernate extends BasicHibernateDao {
  
  public List<MessageHibernate> getAll() {
    return template.execute(action ->  {
      CriteriaBuilder cb = getSession().getCriteriaBuilder();
      CriteriaQuery<MessageHibernate> q = cb.createQuery(MessageHibernate.class);
      return getSession().createQuery(q).setMaxResults(20).getResultList();
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
  
}
