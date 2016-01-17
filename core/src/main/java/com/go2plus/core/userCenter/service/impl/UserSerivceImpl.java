package com.go2plus.core.userCenter.service.impl;

import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import ch.ethz.ssh2.crypto.cipher.AES;

import com.go2plus.common.Constant;
import com.go2plus.common.X;
import com.go2plus.common.encrypt.MD5;
import com.go2plus.common.http.HttpAgent;
import com.go2plus.common.http.SearchEnginUtil;
import com.go2plus.core.common.dao.SettingDao;
import com.go2plus.core.product.dao.SiteDao;
import com.go2plus.core.product.vo.Site;
import com.go2plus.core.userCenter.dao.DaifaDao;
import com.go2plus.core.userCenter.dao.SupplierDao;
import com.go2plus.core.userCenter.dao.UserDao;
import com.go2plus.core.userCenter.service.UserService;
import com.go2plus.core.userCenter.vo.Complain;
import com.go2plus.core.userCenter.vo.Daifa;
import com.go2plus.core.userCenter.vo.Supplier;
import com.go2plus.core.userCenter.vo.SupplierStats;
import com.go2plus.core.userCenter.vo.User;
import com.go2plus.core.userCenter.vo.UserMeta;
import com.go2plus.core.userCenter.vo.supplierMeta;

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
  @Resource
  private SiteDao siteDao;
  @Resource
  private SettingDao settingDao;
  @Resource
  private SupplierDao supplierDao;
  @Resource
  private DaifaDao daifaDao;

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

  public List<Complain> getComplainListById(int userId, int offset, int pageSize) {
    List<Complain> complains = userDao.getComplainListById(userId, offset, pageSize);
    if (complains.size() >= 1)
      return complains;
    else
      return null;
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
   * 根据用户Id查找有用的user_meta用户信息
   * 
   * @param userId
   * @return
   */
  @Override
  public UserMeta findUseMeta(Integer userId) {
    return userDao.findUseMeta(userId);
  }

  /**
   * 更新用户userMeta信息
   * 
   * @param userMeta
   */
  @Override
  public void updateUserMeta(UserMeta userMeta) {
    userDao.updateUserMeta(userMeta);

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
   * 添加供货商
   */
  @Override
  public boolean saveSeller(User user) {
    //先插入一个新的user
     int rt = userDao.insertUser(user);
     if(rt>0){
         user.getUserMeta().setUserId(user.getId());
         userDao.insertMeta(user.getUserMeta());
     }else{
       return false;
     }
    return false;
  }

  /**
   * url验证
   * @return 当true，表示存在
   */
  @Override
  public boolean urlValidate(String url) {
    //查询禁止使用的词汇
    List<String> itemValues = settingDao.findValueByName();
    //包含匹配验证
    for (int i = 0; i < itemValues.size(); i++) {
      String itemValue = itemValues.get(i);
      if(itemValue.indexOf(url)!=-1){
        return true;
      }
    }
    //查询是否为关键字
    String subdomian = siteDao.findSiteBySubdomain(url);
    if(!StringUtils.isEmpty(subdomian)){
      return true;
    }
    return false;
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
  public boolean titleValidate(String title) {
    return !StringUtils.isEmpty(supplierDao.findTitleByTitle(title));
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

  /**
   * 存供货商
   */
  @Override
  public boolean saveSupplier(User user, UserMeta userMeta, Site site, Supplier supplier, supplierMeta supplierMeta,
      SupplierStats supplierStats) {
  //先插入一个新的user
    int rt = userDao.insertUser(user);
    if(rt>0){
        int userId = user.getId();
        userMeta.setUserId(userId);
        supplierMeta.setUserId(userId);
        supplierStats.setUserId(userId);
        userDao.insertMeta(userMeta);
        supplierDao.insertSupplierMeta(supplierMeta);
        supplierDao.insertSupplierStats(supplierStats);
        //插入site
        site.setUserId(userId);
        int siteRt = siteDao.insert(site);
        if(siteRt>0){
          int siteId = site.getId();
          supplier.setUserId(userId);
          supplier.setSiteId(siteId);
          int supplierRt = supplierDao.insert(supplier);
          if(supplierRt>0){
            return true;
          }
        }
    }else{
      return false;
    }
    return false;
  }

  
  /**
   * 代发商注册
   */
  @Override
  public boolean saveDaifa(User user, UserMeta userMeta, Daifa daifa) {
    //先插入一个新的user
    int rt = userDao.insertUser(user);
    if(rt>0){
        userMeta.setUserId(user.getId());
        userDao.insertMeta(userMeta);
        daifa.setUserId(user.getId());
        daifaDao.insert(daifa);
        return true;
    }else{
      return false;
    }
  }

  @Override
  public String findEmailByUserId(int userId) {
    return userDao.findEmailByUserId(userId);
  }

  
}
