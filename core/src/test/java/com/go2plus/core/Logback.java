package com.go2plus.core;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.go2plus.common.mvc.CommonInterceptor;
import com.go2plus.core.user.LogbackT;

public class Logback {
  private final static Logger log = LoggerFactory.getLogger(Logback.class);

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  @Test
  public void test() {
    LogbackT.s();
    
    log.trace("======trace");
    log.debug("======debug");
    log.info("======info");
    log.warn("======warn");
    log.error("======error");
  }

}
