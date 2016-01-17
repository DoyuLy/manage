package com.go2plus.core.guang.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.go2plus.common.Constant;
import com.go2plus.common.redis.RedisUtil;
import com.go2plus.core.portal.controller.PortalController;

/**
Copyright (C) 2015 GO2.CN. All rights reserved.
This computer program source code file is protected by copyright
law and international treaties. Unauthorized distribution of source code files,
programs, or portion of the package, may result in severe civil and criminal
penalties, and will be prosecuted to the maximum extent under the law.
逛逛的定时任务
@author liyang
*/
@Component
public class GuangComponent {
  private final static Logger  log = LoggerFactory.getLogger(GuangComponent.class);
  
  /**
   * 每两个小时清除一次缓存
   */
  @Scheduled(cron = "00 00 0/2 * * ?")
  public void removeGuangRedisKeys() {
    if(RedisUtil.isConnectRedis()){
      String countCategorysRedisKey = "countCategoryMap";
      long countCategorysRedisKeyDelResult = RedisUtil.del(countCategorysRedisKey);
      String result = "没有缓存!";
      if(countCategorysRedisKeyDelResult>0){
        result = Constant.SUCCESS;
      }
      log.info("逛逛删除总数redis缓存结果:"+result);
    }else{
      log.info("redis连接失败!");
    }
  }
  
}
