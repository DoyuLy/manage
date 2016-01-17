package com.go2plus.core.userCenter.service;

import com.go2plus.core.userCenter.vo.User;

public interface UserService {
  /**
   * 根据条件查询用户信息
   * 
   * @param user
   * @return
   */
  public User findUser(User user);

  /**
   * 修改用户
   * 
   * @param user
   * @return
   */
  public int updateUser(User user);

  /**
   * 修改用户手机
   * 
   * @param user
   */
  public void updateUserMobile(User user);

  /**
   * 
   * 更新用户密码
   * 
   * @param user
   */
  public void updateUserPassword(User user);

  public String convertByteArrayToHexString(byte[] hashedBytes);

  public String convertStringToPassword(String s) throws Exception;

  /**
   * 查找用户完整信息
   * 
   * @param userId
   * @return
   */
  public User findFullUserInfo(Integer userId);

 
  /**
   * 根据request传过来的URL查找对应用户id
   * 
   * @param shopUrl
   * @return userId
   */
  public int queryUserIdByUrl(String shopUrl);
  
  /**
   * 检测用户名是否存在
   * @param userName
   * @return 存在返回true
   */
  public boolean isUserNameExist(String userName);

  /**
   * 验证手机号码是否存在
   * @param mobile
   * @return
   */
  public boolean isMobileExist(String mobile);
  
  
  /**
   * 保存采购商
   * @param user
   * @return
   */
  public boolean saveSeller(User user);
  
  /**
   * 验证url
   * @param url
   * @return
   */
  public boolean urlValidate(String url);
  
  /**
   * 邮箱验证
   * @param email
   * @return
   */
  public boolean emailValidate(String email);
  
  /**
   * 厂家用户名验证
   * @param title
   * @return
   */
  public boolean titleValidate(String title);
  
  /**
   * 正则验证数据格式是否合法
   * @param type
   * @param str
   * @return
   */
  public boolean checkData(String type,String str);


  /**
   * 根据userid查询邮箱
   * @param userId
   * @return
   */
  public String findEmailByUserId(int userId);
  

}
