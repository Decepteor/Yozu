package com.jamie.yozu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jamie.yozu.domain.page.PageUser;
import com.jamie.yozu.service.IUserService;

@Controller
@RequestMapping("/register")
public class RegistrationController {
  
  @Autowired
  IUserService userService;

  @GetMapping
  public ModelAndView getPage() {
    return new ModelAndView("login/register");
  }
  
  @PostMapping
  public ModelAndView getPage(PageUser user) {
    if (userService.userIsValid(user)) {
      userService.saveUser(userService.createUser(user));
      return new ModelAndView("login/login");
    }
    else {
      ModelAndView view = new ModelAndView("login/register");
      view.addObject("invalid", "true");
      return view;
    }
    
  }
}
