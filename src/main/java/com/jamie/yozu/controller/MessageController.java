package com.jamie.yozu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jamie.yozu.domain.IMessage;
import com.jamie.yozu.domain.ITag;
import com.jamie.yozu.domain.page.PageMessage;
import com.jamie.yozu.service.IMessageService;
import com.jamie.yozu.service.ITagService;
import com.jamie.yozu.service.IUserIdentificationService;
import com.jamie.yozu.service.IUserService;

@Controller
@RequestMapping("/messages")
public class MessageController {
  
  @Autowired
  IMessageService messageService;
  
  @Autowired
  ITagService tagService;
  
  @Autowired
  IUserIdentificationService userIdentificationService;
  
  @Autowired
  IUserService userService;

  @GetMapping
  public ModelAndView getPage(@RequestParam(required = false) List<String> postTags) {
    
    ModelAndView view = new ModelAndView("messages/messagePage");
    
    addObjects(postTags, view);
    
    return view;
  }



  @PostMapping
  public ModelAndView getPage(PageMessage postMessage, @RequestParam(required = false) List<String> postTags) {
    
    ModelAndView view = new ModelAndView("messages/messagePage");
    
    List<ITag> tags = new ArrayList<>();
    for (String str : postMessage.getTags().split("#")) {
      if (!str.isBlank()) {
        ITag tagByString = tagService.getTagByString(str);
        tags.add(tagByString != null ? tagByString : createAndSave(str));
      }
    }
    
    IMessage actualMessage = messageService.createMessage(postMessage.getTitle(), postMessage.getMessage(), tags,
        userService.getUserByUsername(userIdentificationService.getLoggedInUsername()));
    
    if (messageService.postMessage(actualMessage)) {
      view.addObject("message", "Message posted!");
      view.addObject("messageType", "Success");
    }
    else {
      view.addObject("message", "Message could not be posted, one with the same title was posted in the last 24 hours.");
      view.addObject("messageType", "Failed");
    }
    addObjects(postTags, view);
    
    return view;
  }



  private ITag createAndSave(String str) {
    ITag tag = tagService.createTagFromString(str);
    tagService.saveOrUpdate(tag);
    return tag;
  }

  private void addObjects(List<String> postTags, ModelAndView view) {
    List<? extends ITag> trueTags = new ArrayList<>();
    if (postTags != null) {
      trueTags = tagService.getTagsByStrings(postTags);
    }
    if (!trueTags.isEmpty()) {
      view.addObject("messages", messageService.getAllMessagesContainingTags(trueTags));
    }
    else {
      view.addObject("messages", messageService.getAllMessages());
    }
  }
  
}
