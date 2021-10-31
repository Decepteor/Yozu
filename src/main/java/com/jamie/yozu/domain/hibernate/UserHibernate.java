package com.jamie.yozu.domain.hibernate;

import com.jamie.yozu.domain.IUser;

public class UserHibernate extends BaseDomainHibernate implements IUser {

  @Override
  public String getUsername() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getPassword() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getEmailAddress() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean isAdmin() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void setUsername(String name) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setPassword(String password) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setEmailAddress(String address) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setAdmin(boolean admin) {
    // TODO Auto-generated method stub

  }

}
