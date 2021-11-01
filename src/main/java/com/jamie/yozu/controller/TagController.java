package com.jamie.yozu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jamie.yozu.service.ITagService;

@Controller
@RequestMapping("/tags")
public class TagController {
  
  @Autowired
  ITagService tagService;

  @GetMapping
  public ModelAndView getPage() {
    ModelAndView view =  new ModelAndView("tags/tagPage");
    view.addObject("tags", tagService.getAllTags());
    return view;
  }
  
}
