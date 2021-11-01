package com.jamie.yozu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.jamie.yozu.service.IUserIdentificationService;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
  
  @Autowired
  IUserIdentificationService userIdenficticationService;
  
  @ModelAttribute("user")
  public String getUsername() {
    return userIdenficticationService.getLoggedInUsername();
  }

}
