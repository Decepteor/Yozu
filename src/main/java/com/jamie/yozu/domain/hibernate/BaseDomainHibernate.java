package com.jamie.yozu.domain.hibernate;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.jamie.yozu.domain.IBaseDomain;

@MappedSuperclass
public class BaseDomainHibernate implements IBaseDomain {

  protected Long pk;
  protected LocalDateTime lastUpdated;
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "PK")
  @Override
  public Long getPk() {
    return pk;
  }

  @Override
  public void setPk(Long pk) {
    this.pk = pk;
  }

  @Override
  @Column(name = "LAST_UPDATED")
  public LocalDateTime getLastUpdated() {
    return lastUpdated;
  }

  @Override
  public void setLastUpdated(LocalDateTime lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

}
