package com.jamie.yozu.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.jamie.yozu.domain.IUser;
import com.jamie.yozu.service.IPasswordService;
import com.jamie.yozu.service.IUserService;

@Component
public class AuthenticationProvider implements org.springframework.security.authentication.AuthenticationProvider {
  
  
  @Autowired
  IPasswordService passwordService;
  
  @Autowired
  IUserService userService;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    
    IUser user = userService.getUserByUsername(authentication.getName());
    
    String password = authentication.getCredentials() != null? authentication.getCredentials().toString() : "";
    if (user != null && passwordService.matches(password, user.getPassword())) {
      return new UsernamePasswordAuthenticationToken(user.getUsername(), password, new ArrayList<>());
    }
    else {
      throw new BadCredentialsException("password missmatch");
    }
    
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return true;
  }

}
