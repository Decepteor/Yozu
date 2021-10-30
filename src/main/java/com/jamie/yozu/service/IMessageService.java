package com.jamie.yozu.service;

import java.util.List;

import com.jamie.yozu.domain.IMessage;
import com.jamie.yozu.domain.ITag;

public interface IMessageService {
  
  List<? extends IMessage> getAllMessages();
  List<? extends IMessage> getAllMessagesContainingTags(List<ITag> tags);

}
