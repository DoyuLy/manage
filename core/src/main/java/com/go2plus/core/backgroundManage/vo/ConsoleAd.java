package com.go2plus.core.backgroundManage.vo;

import java.util.Date;

public class ConsoleAd {
  private Integer id;
  private Date startTime;
  private Date endTime;
  private int Type;
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public Date getStartTime() {
    return startTime;
  }
  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }
  public Date getEndTime() {
    return endTime;
  }
  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }
  public int getType() {
    return Type;
  }
  public void setType(int type) {
    Type = type;
  }
  
}
