package com.go2plus.core.common.web.entity;

public class ChangeOrderParameter {

  Integer startInteger; // order_id 起点
  Integer endInteger;  // order_id 终点
  Integer typeInteger; // 移动类型，1上移+1，0下移-1
  Long    userIdLong;  // 用户 id

  public ChangeOrderParameter(Integer startInteger, Integer endInteger, Integer typeInteger, Long userIdLong) {
    this.startInteger = startInteger;
    this.endInteger = endInteger;
    this.typeInteger = typeInteger;
    this.userIdLong = userIdLong;
  }

  public Integer getStartInteger() {
    return startInteger;
  }

  public void setStartInteger(Integer startInteger) {
    this.startInteger = startInteger;
  }

  public Integer getEndInteger() {
    return endInteger;
  }

  public void setEndInteger(Integer endInteger) {
    this.endInteger = endInteger;
  }

  public Integer getTypeInteger() {
    return typeInteger;
  }

  public void setTypeInteger(Integer typeInteger) {
    this.typeInteger = typeInteger;
  }

  public Long getUserIdLong() {
    return userIdLong;
  }

  public void setUserIdLong(Long userIdLong) {
    this.userIdLong = userIdLong;
  }

  

}
