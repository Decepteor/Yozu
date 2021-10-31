package com.jamie.yozu.service;

import java.util.List;

import com.jamie.yozu.domain.IMessage;
import com.jamie.yozu.domain.ITag;
import com.jamie.yozu.domain.IUser;

public interface IMessageService {
  
  List<? extends IMessage> getAllMessages();
  List<? extends IMessage> getAllMessagesContainingTags(List<? extends ITag> list);
  
  boolean postMessage(IMessage message);
  
  IMessage createMessage(String title, String message, List<ITag> tags, IUser user);

}
