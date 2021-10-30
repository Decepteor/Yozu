package com.jamie.yozu.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

import com.jamie.yozu.domain.IUser;
import com.jamie.yozu.service.IPermissionService;
import com.jamie.yozu.service.IUserService;

@SuppressWarnings("rawtypes")
@Component
public class RoleVoter implements AccessDecisionVoter {
  
  @Autowired
  IUserService userService;
  
  @Autowired
  IPermissionService permissionService;

  @Override
  public boolean supports(ConfigAttribute attribute) {
    return true;
  }

  @Override
  public boolean supports(Class clazz) {
    return true;
  }

  @Override
  public int vote(Authentication authentication, Object object, Collection attributes) {
    
    FilterInvocation invocation = (FilterInvocation) object;
    
    String requestUrl = "";
    if (invocation.getRequestUrl().contains("?")) {
      requestUrl = invocation.getRequestUrl().substring(0, invocation.getRequestUrl().indexOf("?"));
    }
    else {
      requestUrl = invocation.getRequestUrl();
    }

    if (authentication instanceof AnonymousAuthenticationToken) {
      return ACCESS_ABSTAIN;
    }

    IUser user = userService.getUserByUsername(authentication.getPrincipal().toString());
    
    if (user != null) {
      if (permissionService.isAdminUrl(requestUrl)) {
        return user.isAdmin() ? ACCESS_GRANTED : ACCESS_DENIED;
      }
      else {
        return ACCESS_GRANTED;
      }
    }
    
    return ACCESS_DENIED;
  }

}
