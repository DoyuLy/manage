package com.go2plus.core.promotion.vo;

import java.util.Date;

public class AdPosition {
  public int id;
  public String posX;
  public String posY;
  public Date startTime;
  public Date endTime;
  public int type;
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getPosX() {
    return posX;
  }
  public void setPosX(String posX) {
    this.posX = posX;
  }
  public String getPosY() {
    return posY;
  }
  public void setPosY(String posY) {
    this.posY = posY;
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
    return type;
  }
  public void setType(int type) {
    this.type = type;
  }
  
}
