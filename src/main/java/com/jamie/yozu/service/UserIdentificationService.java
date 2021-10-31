package com.jamie.yozu.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserIdentificationService implements IUserIdentificationService {

  @Override
  public String getLoggedInUsername() {
    return SecurityContextHolder.getContext().getAuthentication() != null ?
        SecurityContextHolder.getContext().getAuthentication().getName(): "";
  }

}
