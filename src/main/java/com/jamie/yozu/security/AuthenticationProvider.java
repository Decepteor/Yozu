package com.jamie.yozu.security;

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
    
    if (passwordService.matches(authentication.getCredentials().toString(), user.getPassword())) {
      return new UsernamePasswordAuthenticationToken(user.getUsername(), authentication.getCredentials().toString());
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
