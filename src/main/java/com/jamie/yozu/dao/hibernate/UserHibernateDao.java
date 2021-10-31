package com.jamie.yozu.dao.hibernate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.jamie.yozu.domain.hibernate.UserHibernate;

@Repository
public class UserHibernateDao extends BasicHibernateDao {

  public UserHibernate getUserByUsername(String username) {
    return template.execute(action -> {
      CriteriaBuilder cb = getSession().getCriteriaBuilder();
      CriteriaQuery<UserHibernate> q = cb.createQuery(UserHibernate.class);
      Root<UserHibernate> root = q.from(UserHibernate.class);
      Predicate pred = cb.equal(root.get("username"), username);
      q.where(pred);
      return getSession().createQuery(q).uniqueResult();
    });
  }
  
}
