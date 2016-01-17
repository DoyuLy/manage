package com.go2plus.core.userCenter.vo;

import java.util.Date;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * 记录商家评分及排名数据
 * SupplierRank
 * @author yyl
 * @since 2015-11-16
 *
 */
public class SupplierRank {
  private Integer id;          // 表主键
  private Integer userId;      // 关联user表id 商家用户ID
  private Integer rank;        // 商家排名
  private Integer score;       // 商家评分
  private Date    createTime;  // 记录创建时间
  
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public Integer getUserId() {
    return userId;
  }
  public void setUserId(Integer userId) {
    this.userId = userId;
  }
  public Integer getRank() {
    return rank;
  }
  public void setRank(Integer rank) {
    this.rank = rank;
  }
  public Integer getScore() {
    return score;
  }
  public void setScore(Integer score) {
    this.score = score;
  }
  public Date getCreateTime() {
    return createTime;
  }
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
  
  public Integer converteScoreToLevel() {
    if (score > 10000000) {
      return 20;
    } else if (score > 5000000) {
      return 19;
    } else if (score > 2000000) {
      return 18;
    } else if (score > 1000000) {
      return 17;
    } else if (score > 500000) {
      return 16;
    } else if (score > 200000) {
      return 15;
    } else if (score > 100000) {
      return 14;
    } else if (score > 50000) {
      return 13;
    } else if (score > 20000) {
      return 12;
    } else if (score > 10000) {
      return 11;
    } else if (score > 5000) {
      return 10;
    } else if (score > 2000) {
      return 9;
    } else if (score > 1000) {
      return 8;
    } else if (score > 500) {
      return 7;
    } else if (score > 250) {
      return 6;
    } else if (score > 150) {
      return 5;
    } else if (score > 90) {
      return 4;
    } else if (score > 40) {
      return 3;
    } else if (score > 10) {
      return 2;
    } else {
      return 1;
    }
  }
  
}
