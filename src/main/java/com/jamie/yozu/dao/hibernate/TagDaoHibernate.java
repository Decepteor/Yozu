package com.jamie.yozu.dao.hibernate;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.jamie.yozu.domain.hibernate.TagHibernate;

@Repository
public class TagDaoHibernate extends BasicHibernateDao {
  
  public List<TagHibernate> getAll() {
    return template.execute(action ->  {
      CriteriaBuilder cb = getSession().getCriteriaBuilder();
      CriteriaQuery<TagHibernate> q = cb.createQuery(TagHibernate.class);
      Root<TagHibernate> root = q.from(TagHibernate.class);
      return getSession().createQuery(q.orderBy(cb.desc(root.get("lastUpdated"))).select(root)).getResultList();
      });
  }
  
  public List<TagHibernate> getMostRecent20() {
    return template.execute(action ->  {
      CriteriaBuilder cb = getSession().getCriteriaBuilder();
      CriteriaQuery<TagHibernate> q = cb.createQuery(TagHibernate.class);
      Root<TagHibernate> root = q.from(TagHibernate.class);
      return getSession().createQuery(q.orderBy(cb.desc(root.get("lastUpdated")))).setMaxResults(20).getResultList();
      });
  }
  
  public List<TagHibernate> getAllTagsFromStrings(List<String> strings) {
    return template.execute(action ->  {
      CriteriaBuilder cb = getSession().getCriteriaBuilder();
      CriteriaQuery<TagHibernate> q = cb.createQuery(TagHibernate.class);
      Root<TagHibernate> root = q.from(TagHibernate.class);
      q.where(root.get("tag").in(strings));
      return getSession().createQuery(q).setMaxResults(20).getResultList();
      });
  }
  
  public TagHibernate getTagFromString(String str) {
    return template.execute(action ->  {
      CriteriaBuilder cb = getSession().getCriteriaBuilder();
      CriteriaQuery<TagHibernate> q = cb.createQuery(TagHibernate.class);
      Root<TagHibernate> root = q.from(TagHibernate.class);
      q.where(cb.equal(root.get("tag"), str));
      return getSession().createQuery(q).uniqueResult();
      });
  }

}
