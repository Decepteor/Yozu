package com.jamie.yozu.service;

import java.util.List;

import com.jamie.yozu.domain.ITag;

public interface ITagService {

  List<? extends ITag> getTagsByStrings(List<String> strings);
  
  List<? extends ITag> getAllTags();
  
  ITag getTagByString(String tag);
  
  ITag createTagFromString(String tag);
  
}
