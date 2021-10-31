package com.jamie.yozu.domain.hibernate;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jamie.yozu.domain.IMessage;
import com.jamie.yozu.domain.ITag;
import com.jamie.yozu.domain.IUser;

@Entity
@Table(name = "MESSAGES")
public class MessageHibernate extends BaseDomainHibernate implements IMessage {
  
  private String message;
  private String title;
  private UserHibernate user;
  private List<TagHibernate> tags;

  @Override
  @Column(name = "MESSAGE")
  public String getMessage() {
    return message;
  }

  @Override
  @Column(name = "TITLE")
  public String getTitle() {
    return title;
  }

  @Override
  @JoinTable(name = "MESSAGE_TAG", 
  joinColumns = @JoinColumn(name = "MESSAGE_PK"), 
  inverseJoinColumns = @JoinColumn(name="TAG_PK"))
  public List<TagHibernate> getTags() {
    return tags;
  }

  @Override
  @JoinColumn(name = "USER_FK")
  @ManyToOne
  public UserHibernate getUser() {
    return user;
  }

  @Override
  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public void setTitle(String title) {
    this.title = title;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void setTags(List<? extends ITag> tags) {
    this.tags = (List<TagHibernate>) tags;
  }

  @Override
  public void setUser(IUser user) {
    this.user = (UserHibernate) user;
  }

}
