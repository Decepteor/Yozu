package com.jamie.yozu.domain;

public interface IUser extends IBaseDomain {

  String getUsername();
  String getPassword();
  String getEmailAddress();
  boolean isAdmin();
  
  void setUsername(String name);
  void setPassword(String password);
  void setEmailAddress(String address);
  void setAdmin(boolean admin);
  
  
}
