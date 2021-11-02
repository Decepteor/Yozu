package com.jamie.yozu.service;

import com.jamie.yozu.domain.IUser;
import com.jamie.yozu.domain.page.PageUser;

public interface IUserService {
  
  public IUser getUserByUsername(String username);
  public void saveUser(IUser user);
  public IUser createUser(PageUser user);
  public boolean userIsValid (PageUser user);
  
  
}
