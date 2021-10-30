package com.jamie.yozu.dao;

import com.jamie.yozu.domain.IBaseDomain;

public interface IBasicDao {
  
  void saveOrUpdate(IBaseDomain object);
  public <T extends IBaseDomain> T getByPk(int pk, Class<T> clazz);

}
