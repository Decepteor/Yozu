package com.jamie.yozu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jamie.yozu.dao.IBasicDao;
import com.jamie.yozu.domain.IBaseDomain;

@Service
public abstract class AbstractBaseService implements IBaseService {
  
  @Autowired
  @Qualifier("basicHibernateDao")
  IBasicDao basicDao;
  
  @Override
  public void saveOrUpdate(IBaseDomain object) {
    basicDao.saveOrUpdate(object);
  }

  @Override
  public <T extends IBaseDomain> T getByPk(int pk, Class<T> clazz) {
    return basicDao.getByPk(pk, clazz);
  }

}
