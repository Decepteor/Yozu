package com.jamie.yozu.domain;

import java.time.LocalDateTime;

public interface IBaseDomain {
  
  Integer getPk();
  void setPk(Integer pk);
  LocalDateTime getLastUpdated();
  void setLastUpdated(LocalDateTime lastUpdated);
}
