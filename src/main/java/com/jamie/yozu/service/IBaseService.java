package com.jamie.yozu.service;

import com.jamie.yozu.domain.IBaseDomain;

public interface IBaseService {
  
  void saveOrUpdate(IBaseDomain object);
  public <T extends IBaseDomain> T getByPk(int pk, Class<T> clazz);

}
