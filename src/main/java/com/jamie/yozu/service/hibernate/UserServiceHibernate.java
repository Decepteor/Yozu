package com.jamie.yozu.service.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamie.yozu.dao.hibernate.UserHibernateDao;
import com.jamie.yozu.domain.IUser;
import com.jamie.yozu.service.AbstractBaseService;
import com.jamie.yozu.service.IUserService;

@Service
public class UserServiceHibernate extends AbstractBaseService implements IUserService {
  
  @Autowired
  UserHibernateDao userHibernateDao;

  @Override
  public IUser getUserByUsername(String username) {
    return userHibernateDao.getUserByUsername(username);
  }

  @Override
  public void saveUser(IUser user) {
    userHibernateDao.saveOrUpdate(user);
  }

}
