package com.jamie.yozu.dao.hibernate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionTemplate;

import com.jamie.yozu.dao.IBasicDao;
import com.jamie.yozu.domain.IBaseDomain;

@Repository
public class BasicHibernateDao implements IBasicDao {
  
  @Autowired
  SessionFactory sessionFactory;
  
  @Autowired
  protected TransactionTemplate template;

  @Override
  public void saveOrUpdate(IBaseDomain object) {
    template.executeWithoutResult(trans -> getSession().saveOrUpdate(object));
  }

  @Override
  public <T extends IBaseDomain> T getByPk(int pk, Class<T> clazz) {
    return (T) template.execute(trans -> {
      CriteriaBuilder cb = getSession().getCriteriaBuilder();
      CriteriaQuery<T> q = cb.createQuery(clazz);
      Root<T> root = q.from(clazz);
      Predicate pred = cb.equal(root.get("pk"), pk);
      q.where(pred);
      return getSession().createQuery(q).uniqueResult();
    });
     
  }
  
  protected Session getSession() {
    return sessionFactory.getCurrentSession();
  }

}
