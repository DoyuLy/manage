package com.go2plus.core.userCenter.vo;

import java.util.Date;

/**
 * @author duyu 记录网站注册用户的相关信息
 */
public class User {
  private Integer       id;
  private Integer       type;
  private String        username;
  private String        password;
  private String        mobile;
  private Integer       isMobileVerified;
  private Date          mobileVerifiedTime;
  private Date          mobileSendTime;
  private Date          lastLoginTime;
  private String        lastLoginIp;
  private Integer       state;
  private Date          createTime;
  private String        createIp;
  private Date          updateTime;
  private String        lastSession;
  private Date          lastSessionTime;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public Integer getIsMobileVerified() {
    return isMobileVerified;
  }

  public void setIsMobileVerified(Integer isMobileVerified) {
    this.isMobileVerified = isMobileVerified;
  }

  public Date getMobileVerifiedTime() {
    return mobileVerifiedTime;
  }

  public void setMobileVerifiedTime(Date mobileVerifiedTime) {
    this.mobileVerifiedTime = mobileVerifiedTime;
  }

  public Date getMobileSendTime() {
    return mobileSendTime;
  }

  public void setMobileSendTime(Date mobileSendTime) {
    this.mobileSendTime = mobileSendTime;
  }

  public Date getLastLoginTime() {
    return lastLoginTime;
  }

  public void setLastLoginTime(Date lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }

  public String getLastLoginIp() {
    return lastLoginIp;
  }

  public void setLastLoginIp(String lastLoginIp) {
    this.lastLoginIp = lastLoginIp;
  }
  
  public Integer getState() {
    return state;
  }

  public void setState(Integer state) {
    this.state = state;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getCreateIp() {
    return createIp;
  }

  public void setCreateIp(String createIp) {
    this.createIp = createIp;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public String getLastSession() {
    return lastSession;
  }

  public void setLastSession(String lastSession) {
    this.lastSession = lastSession;
  }

  public Date getLastSessionTime() {
    return lastSessionTime;
  }

  public void setLastSessionTime(Date lastSessionTime) {
    this.lastSessionTime = lastSessionTime;
  }
}