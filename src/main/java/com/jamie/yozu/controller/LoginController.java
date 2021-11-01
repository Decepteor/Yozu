package com.jamie.yozu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {

  @GetMapping
  public ModelAndView getLoginPage() {
    return new ModelAndView("login/login");
  }
  
}
