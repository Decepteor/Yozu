package com.jamie.yozu.service;

import java.util.List;

import com.jamie.yozu.domain.ITag;

public interface ITagService extends IBaseService {

  List<? extends ITag> getTagsByStrings(List<String> strings);
  
  List<? extends ITag> getAllTags();
  
  List<? extends ITag> getMostRecentTags();
  
  ITag getTagByString(String tag);
  
  ITag createTagFromString(String tag);
  
}
