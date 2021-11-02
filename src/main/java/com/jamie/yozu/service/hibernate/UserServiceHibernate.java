package com.jamie.yozu.service.hibernate;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamie.yozu.dao.hibernate.UserHibernateDao;
import com.jamie.yozu.domain.IUser;
import com.jamie.yozu.domain.hibernate.UserHibernate;
import com.jamie.yozu.domain.page.PageUser;
import com.jamie.yozu.service.AbstractBaseService;
import com.jamie.yozu.service.IUserService;
import com.jamie.yozu.service.PasswordService;

@Service
public class UserServiceHibernate extends AbstractBaseService implements IUserService {
  
  @Autowired
  UserHibernateDao userHibernateDao;
  
  @Autowired
  PasswordService passwordService;

  @Override
  public IUser getUserByUsername(String username) {
    return userHibernateDao.getUserByUsername(username);
  }

  @Override
  public void saveUser(IUser user) {
    userHibernateDao.saveOrUpdate(user);
  }

  @Override
  public IUser createUser(PageUser user) {
    UserHibernate userObj = new UserHibernate();
    
    userObj.setAdmin(false);
    String emailAdress = user.getEmailAdress();
    userObj.setEmailAddress(emailAdress);
    userObj.setPassword(passwordService.encode(user.getPassword()));
    userObj.setUsername(user.getUsername());
    userObj.setLastUpdated(LocalDateTime.now());
    
    return userObj;
  }

  @Override
  public boolean userIsValid(PageUser user) {
    return checkNotEmpty(user) && checkLength(user);
  }

  private boolean checkNotEmpty(PageUser user) {
    return user.getEmailAdress() != null && !user.getEmailAdress().isBlank() &&
           user.getPassword() != null && !user.getPassword().isBlank() &&
           user.getUsername() != null && !user.getUsername().isBlank();
}

  private boolean checkLength(PageUser user) {
    return user.getEmailAdress().length() < 50 &&
           user.getPassword().length() < 30 &&
           user.getUsername().length() < 50;
  }

}
