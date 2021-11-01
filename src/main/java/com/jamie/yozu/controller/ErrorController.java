package com.jamie.yozu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/error")
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
  
  @GetMapping
  public ModelAndView getPage() {
    return new ModelAndView("error/errorPage");
  }

}
