package com.go2plus.core.userCenter.service.impl;

import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.go2plus.common.X;
import com.go2plus.common.encrypt.MD5;
import com.go2plus.core.userCenter.dao.UserDao;
import com.go2plus.core.userCenter.service.UserService;
import com.go2plus.core.userCenter.vo.User;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 */
@Service
public class UserSerivceImpl implements UserService {

  private User    user;

  @Resource
  private UserDao userDao;

  /**
   * 修改用户手机
   * 
   * @param user
   */
  @Override
  public void updateUserMobile(User user) {
    userDao.updateUserMobile(user);
  }

  /**
   * 条件查询用户
   * 
   * @param user
   * @return
   */
  @Override
  public User findUser(User user) {
    return userDao.findUser(user);
  }

  /**
   * 修改用户
   * 
   * @param user
   * @return
   */
  @Override
  public int updateUser(User user) {
    return userDao.updateUser(user);
  }

  /**
   * 
   * 更新用户密码
   * 
   * @param user
   */
  @Override
  public void updateUserPassword(User user) {
    userDao.updateUserPassword(user);
  }

  public String convertByteArrayToHexString(byte[] hashedBytes) {
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 0; i < hashedBytes.length; i++) {
      stringBuffer.append(Integer.toString((hashedBytes[i] & 0xff) + 0x100, 16).substring(1));
    }
    return stringBuffer.toString();
  }

  public String convertStringToPassword(String s) throws Exception {
    return MD5.md5Encode(X.USER_PASS_PREFIX + s);
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public UserDao getUserDao() {
    return userDao;
  }

  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }

 

  /**
   * 查找用户完整信息
   * 
   * @param userId
   * @return
   */
  @Override
  public User findFullUserInfo(Integer userId) {
    return userDao.findFullUserInfo(userId);
  }

 
  
  /**
   * 根据request传过来的URL查找对应用户id
   * 
   * @param shopUrl
   * @return userId
   */
  @Override
  public int queryUserIdByUrl(String shopUrl) {
    return userDao.queryUserIdByUrl(shopUrl);
  }

  /**
   * 检测用户名是否存在
   * @param userName
   * @return
   */
  @Override
  public boolean isUserNameExist(String userName) {
    return userDao.findUserNameByUserName(userName)==null?false:true;
  }

  /**
   * 验证手机号码是否存在
   */
  @Override
  public boolean isMobileExist(String mobile) {
    return userDao.findMobileByMobile(mobile)==null?false:true;
  }

  

  

  /**
   * 邮箱验证
   * 存在返回true
   */
  @Override
  public boolean emailValidate(String email) {
    return !StringUtils.isEmpty(userDao.findEmailByEmail(email));
  }

 

  @Override
  public boolean checkData(String type, String str) {
    String qq = "^[1-9][0-9]{4,}$";
    String email = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    String mobile = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
    String title = "(^[a-z0-9A-Z])[a-z0-9A-Z_]+([a-z0-9-A-Z])";
    String username = "^[a-zA-Z0-9\u4E00-\u9FA5]+$";//只能为汉字数字字母
    String link = "^[a-z0-9]{3,16}$";
    String chn = "^[\u4e00-\u9fa5]{2,10}$";//只能为2-10位汉字
    if(type.equals("qq")){
      return Pattern.matches(qq, str); 
    }else if(type.equals("email")){
      return Pattern.matches(email, str); 
    }else if(type.equals("mobile")){
      return Pattern.matches(mobile, str); 
    }else if(type.equals("title")){
      return Pattern.matches(title, str); 
    }else if(type.equals("username")){
      return Pattern.matches(username, str); 
    }else if(type.equals("link")){
      return Pattern.matches(link, str); 
    }else if(type.equals("chn")){
      return Pattern.matches(chn, str);
    }
    return false;
  }

  @Override
  public String findEmailByUserId(int userId) {
    return userDao.findEmailByUserId(userId);
  }

@Override
public boolean saveSeller(User user) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean urlValidate(String url) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean titleValidate(String title) {
	// TODO Auto-generated method stub
	return false;
}

  
}
