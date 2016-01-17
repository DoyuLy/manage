package com.go2plus.core.backgroundManage.crontab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

import com.go2plus.common.Constant;
import com.go2plus.common.redis.RedisUtil;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law. 逛逛的定时任务
 * 
 * @author gzh
 */
public class ProductPrevire {
  private final static Logger logger = LoggerFactory.getLogger(ProductPrevire.class);

  /**
   * 产品预览页的生产周期与登录超时时间一致
   */
  @Scheduled(cron = "00 00 0/2 * * ?")
  public void removeProductPreviewRedis() {
    if (RedisUtil.isConnectRedis()) {
      String redisKey = "51";
      long countRedisKey = RedisUtil.del(redisKey);
      String result = "产品预览没有缓存";
      if (countRedisKey > 0) {
        result = Constant.SUCCESS;
      }
      logger.info("产品预览redis缓存情况：" + result);
    } else {
      logger.info("redis连接失败!");
    }
  }

}
