package com.go2plus.core.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogbackT {
  private final static Logger log = LoggerFactory.getLogger(LogbackT.class);
  
  public static void s(){
    log.trace("======trace");
    log.debug("======debug");
    log.info("======info");
    log.warn("======warn");
    log.error("======error");
  }
}
