package com.jamie.yozu.domain;

import java.time.LocalDateTime;

public interface IBaseDomain {
  
  Long getPk();
  void setPk(Long pk);
  LocalDateTime getLastUpdated();
  void setLastUpdated(LocalDateTime lastUpdated);
}
