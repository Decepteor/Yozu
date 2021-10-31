package com.jamie.yozu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService implements IPasswordService {
  
  @Autowired
  PasswordEncoder encoder;

  @Override
  public boolean matches(String raw, String stored) {
     return encoder.matches(raw, stored);
  }

  @Override
  public String encode(String password) {
    return encoder.encode(password);
  }

}
