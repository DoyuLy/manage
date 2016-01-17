package com.go2plus.core.userCenter.service;

import java.util.HashMap;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.go2plus.common.mvc.Pagination;
import com.go2plus.core.userCenter.vo.ScoreCategory;
import com.go2plus.core.userCenter.vo.Supplier;
import com.go2plus.core.userCenter.vo.SupplierCreditNew;
import com.go2plus.core.userCenter.vo.SupplierRank;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * SupplierService Service
 * 
 * @author yuyanlin
 * @since 2015-11-03
 */

public interface SupplierService {

  /**
   * 根据用户Id 查找厂家
   * 
   * @param userId
   * @return
   */
  public Supplier findSupplierByUserId(Integer userId);

  /**
   * 更新厂家信息
   * 
   * @param supplier
   */
  public void updateSupplierProfile(Supplier supplier);

  /**
   * 获取厂家认证状态
   * 
   * @param user_Id
   * @return String
   */
  public String getCertifiedType(int i);

  // 更换产品标签
  public void updateLable(HashMap<String, Object> map);

  /**
   * 获取厂家最近一周发布新款情况
   * 
   * @param user_Id
   * @return integer
   */
  public int getWeekPublish(int i);

  /**
   * 获取厂家最近一周被发布到淘宝的产品数量
   * 
   * @param user_Id
   * @return integer
   */
  public int getWeekTaobao(int i);

  /**
   * 获取厂家最近一周被下载的产品数量
   * 
   * @param user_Id
   * @return integer
   */
  public int getWeekDownload(int i);

  /**
   * 获取最近90天下载或发布过该厂家产品的卖家数量
   * 
   * @param user_Id
   * @return integer
   */
  public int getNinetySeller(int i);

  /**
   * 获取所有发布过该厂家产品的卖家数
   * 
   * @param user_Id
   * @return integer
   */
  public int getAllSeller(int i);

  
  public void getDownloadedProducts(Integer userId, String year);

  /**
   * vip下载
   * 
   * @param supplierId
   * @return
   */
  PageInfo<HashMap<Object, Object>> vipDownload(int supplierId, Pagination pagination);

  /**
   * 产品下载
   * 
   * @param supplierId
   * @return
   */
  public PageInfo<HashMap<Object, Object>> productDownload(int supplierId,Pagination pagination);

  /**
   * 淘宝产品列表
   * 
   * @param supplierId
   * @return
   */
  public PageInfo<HashMap<Object, Object>> taobaoProductPublish(int supplierId,Pagination pagination);
  /**
   * 认证商家查找
   * 
   * @param marketId
   * @param capital
   * @param Sort
   * @param keyword
   * @return
   */
  public PageInfo getSupplierByCondition(Integer marketId, String capital, Integer sort, String keyword, Pagination pagination);

  /**
   * 根据marketId去查找大写字母
   * 
   * @param marketId
   * @param keyword
   * @return
   */
  public List<Supplier> getCapitalByCondition(Integer marketId, String keyword);

  /**
   * 将分数转化成等级
   * 
   * @param supplier
   * @return 商家等级
   */
  public Integer converteScoreToLevel(Integer score);

  /**
   * 厂家积分详情
   * 
   * @param userId
   * @return
   */
  public List<SupplierCreditNew> scoreDetail(Integer userId);
  
  /**
   * 用于积分管理生产分类下拉列表
   * 
   * @return
   */
  public List<ScoreCategory> getScoreCategory();
  
  /**
   * 积分统计
   * @return
   */
  public List<SupplierCreditNew> getScoreTotal(Integer userId);
  
  /**
   * 获取厂家排名
   * 
   * @param userId
   * @return
   */
  public SupplierRank getRankByUserId(Integer userId);
}
