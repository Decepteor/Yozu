package com.jamie.yozu.domain;

import java.util.List;

public interface IMessage extends IBaseDomain {

  String getMessage();
  String getTitle();
  List<? extends ITag> getTags();
  IUser getUser();
  
  void setMessage(String message);
  void setTitle(String title);
  void setTags(List<? extends ITag> tags);
  void setUser(IUser user);
  
}
