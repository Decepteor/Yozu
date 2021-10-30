package com.jamie.yozu.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface IPermissionService {
  
  static List<String> adminUrls = Stream.of("/admin/users").collect(Collectors.toList());
  
  default boolean isAdminUrl(String url) {
    return adminUrls.contains(url);
  }

}
