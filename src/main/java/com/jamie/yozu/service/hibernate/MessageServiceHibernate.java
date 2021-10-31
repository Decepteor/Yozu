package com.jamie.yozu.service.hibernate;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamie.yozu.dao.hibernate.MessageDaoHibernate;
import com.jamie.yozu.domain.IMessage;
import com.jamie.yozu.domain.ITag;
import com.jamie.yozu.domain.IUser;
import com.jamie.yozu.domain.hibernate.MessageHibernate;
import com.jamie.yozu.domain.hibernate.TagHibernate;
import com.jamie.yozu.domain.hibernate.UserHibernate;
import com.jamie.yozu.service.AbstractBaseService;
import com.jamie.yozu.service.IMessageService;

@Service
public class MessageServiceHibernate extends AbstractBaseService implements IMessageService {
  
  @Autowired
  MessageDaoHibernate messageDaoHibernate;

  @Override
  public List<? extends IMessage> getAllMessages() {
    return messageDaoHibernate.getAll();
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<? extends IMessage> getAllMessagesContainingTags(List<? extends ITag> list) {
    return messageDaoHibernate.getAllMessagesContainingTags((List<TagHibernate>) list);
  }

  @Override
  public boolean postMessage(IMessage message) {
    if (messageDaoHibernate.isMessageWithTitleForUserInLast24Hours(message.getTitle(), 
                                                    (UserHibernate)message.getUser())) {
      return false;
    }
    messageDaoHibernate.saveOrUpdate(message);
    return true;
  }

  @Override
  public IMessage createMessage(String title, String message, List<ITag> tags, IUser user) {
    MessageHibernate messageObj = new MessageHibernate();
    if (title.length() > 50) {
      messageObj.setTitle(title.substring(0, 50));
    }
    else {
      messageObj.setTitle(title);
    }
    if (message.length() > 300) {
      messageObj.setMessage(message.substring(0, 300));
    }
    else {
      messageObj.setMessage(message);
    }
    messageObj.setLastUpdated(LocalDateTime.now());
    messageObj.setUser(user);
    messageObj.setTags(tags);
    return messageObj;
  }

}
