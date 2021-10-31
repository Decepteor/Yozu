package com.jamie.yozu.domain.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.jamie.yozu.domain.ITag;

@Entity
@Table(name = "TAGS")
public class TagHibernate extends BaseDomainHibernate implements ITag {
  
  private String tag;

  @Override
  @Column(name = "TAG")
  public String getTag() {
    return tag;
  }

  @Override
  public void setTag(String tag) {
    this.tag = tag;
  }

}
