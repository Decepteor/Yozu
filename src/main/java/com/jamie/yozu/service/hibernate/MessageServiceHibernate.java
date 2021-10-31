package com.jamie.yozu.service.hibernate;

import java.util.List;

import com.jamie.yozu.domain.IMessage;
import com.jamie.yozu.domain.ITag;
import com.jamie.yozu.domain.IUser;
import com.jamie.yozu.service.AbstractBaseService;
import com.jamie.yozu.service.IMessageService;

public class MessageServiceHibernate extends AbstractBaseService implements IMessageService {

  @Override
  public List<? extends IMessage> getAllMessages() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<? extends IMessage> getAllMessagesContainingTags(List<? extends ITag> list) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean postMessage(IMessage message) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public IMessage createMessage(String title, String message, List<ITag> tags, IUser user) {
    // TODO Auto-generated method stub
    return null;
  }

}
