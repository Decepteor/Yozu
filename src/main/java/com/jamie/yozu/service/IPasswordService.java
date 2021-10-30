package com.jamie.yozu.service;

public interface IPasswordService {
  
  public boolean matches(String raw, String stored);
  
  public String encode(String password);

}
