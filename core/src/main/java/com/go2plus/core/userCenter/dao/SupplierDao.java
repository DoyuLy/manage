package com.go2plus.core.userCenter.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.go2plus.common.mvc.DAO;
import com.go2plus.core.userCenter.vo.ScoreCategory;
import com.go2plus.core.userCenter.vo.Supplier;
import com.go2plus.core.userCenter.vo.SupplierCreditNew;
import com.go2plus.core.userCenter.vo.SupplierRank;
import com.go2plus.core.userCenter.vo.SupplierStats;
import com.go2plus.core.userCenter.vo.supplierMeta;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * SupplierDao Dao
 * 
 * @author yuyanlin
 * @since 2015-11-03
 */

public interface SupplierDao extends DAO {

  public Supplier findSupplierByUserId(Integer userId);

  public void updateSupplierProfile(Supplier supplier);

  /**
   * 会员下载统计
   * 
   * @param supplier
   * @return
   */
  List<HashMap<Object, Object>> vipUserDownload(int supplierId);

  /**
   * 产品下载记录
   * 
   * @param supplierId
   * @return
   */
  List<HashMap<Object, Object>> productDownload(int supplierId);

  /**
   * 淘宝产品下载
   * 
   * @param supplierId
   * @return
   */
  List<HashMap<Object, Object>> taobaoProductPublish(int supplierId);

  /**
   * 认证商家查找
   * 
   * @param marketId
   * @param capital
   * @param sort
   * @param keyword
   * @return
   */
  public List<Supplier> getSupplierByCondition(Integer marketId, String capital, Integer sort, String keyword);

  /**
   * 根据marketId去查找大写字母
   * 
   * @param marketId
   * @param keyword
   * @return
   */
  public List<Supplier> getCapitalByCondition(Integer marketId, String keyword);
  
  /**
   * 获取厂家排名
   * 
   * @param userId
   * @return
   */
  public SupplierRank getSupplierRankByUserId(Integer userId);
  
  /**
   * 获取前500名厂家积分
   * 
   * @return
   */
  public List<SupplierRank> getTop500();
  
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

  
  public String findTitleByTitle(@Param("title") String title);
  
  /**
   * 插入supplier
   * @param supplier
   * @return
   */
  public int insert(Supplier supplier);
  
  /**
   * 插入supplierMeta
   * @param supplierMeta
   * @return
   */
  public int insertSupplierMeta(supplierMeta supplierMeta);
  
  
  /**
   * 初始化供货商统计
   * @param supplierStats
   * @return
   */
  public int insertSupplierStats(SupplierStats supplierStats);
  /**
   * 获取商家信息
   * 功能模块：商家广告管理
   * @param userId
   * @return
   */
  public Supplier getByUserId(@Param("userId")Integer userId);

}
