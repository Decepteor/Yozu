package com.jamie.yozu.exceptions;

import java.io.IOException;

public class FailedToStartExeception extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = -8310384887342676513L;
  
  public FailedToStartExeception(String str, IOException ex) {
    super(str, ex);
  }

}
