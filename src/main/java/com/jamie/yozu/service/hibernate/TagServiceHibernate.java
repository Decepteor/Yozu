package com.jamie.yozu.service.hibernate;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jamie.yozu.dao.hibernate.TagDaoHibernate;
import com.jamie.yozu.domain.ITag;
import com.jamie.yozu.domain.hibernate.TagHibernate;
import com.jamie.yozu.service.AbstractBaseService;
import com.jamie.yozu.service.ITagService;

public class TagServiceHibernate extends AbstractBaseService implements ITagService {

  @Autowired
  TagDaoHibernate tagDao;
  
  @Override
  public List<? extends ITag> getTagsByStrings(List<String> strings) {
    return tagDao.getAllTagsFromStrings(strings);
  }

  @Override
  public List<? extends ITag> getAllTags() {
    return tagDao.getAll();
  }

  @Override
  public ITag getTagByString(String tag) {
    return null;
  }

  @Override
  public ITag createTagFromString(String tag) {
    TagHibernate tagOb = new TagHibernate();
    tagOb.setTag(tag);
    tagOb.setLastUpdated(LocalDateTime.now());
    return tagOb;
  }

}
