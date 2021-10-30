package com.jamie.yozu.service;

import com.jamie.yozu.domain.IUser;

public interface IUserService {
  
  public IUser getUserByUsername(String username);
  public void saveUser(IUser user);

}
