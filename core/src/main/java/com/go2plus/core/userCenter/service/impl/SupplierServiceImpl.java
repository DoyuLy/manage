package com.go2plus.core.userCenter.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.go2plus.common.mvc.Pagination;
import com.go2plus.core.product.dao.ProductDao;
import com.go2plus.core.product.vo.Product;
import com.go2plus.core.userCenter.dao.SupplierDao;
import com.go2plus.core.userCenter.dao.UserDao;
import com.go2plus.core.userCenter.service.SupplierService;
import com.go2plus.core.userCenter.vo.ScoreCategory;
import com.go2plus.core.userCenter.vo.Supplier;
import com.go2plus.core.userCenter.vo.SupplierCreditNew;
import com.go2plus.core.userCenter.vo.SupplierRank;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * SupplierServiceImpl Service Impl
 * 
 * @author yuyanlin
 * @since 2015-11-03
 */

@Service
public class SupplierServiceImpl implements SupplierService {

  private String      certifiedType;

  @Resource
  private SupplierDao supplierDao;

  @Resource
  private UserDao     userDao;

  @Resource
  private ProductDao  productDao;

  public String getCertifiedType() {
    return certifiedType;
  }

  public void setCertifiedType(String certifiedType) {
    this.certifiedType = certifiedType;
  }

  public UserDao getUserDao() {
    return userDao;
  }

  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }

  public ProductDao getProductDao() {
    return productDao;
  }

  public void setProductDao(ProductDao productDao) {
    this.productDao = productDao;
  }

  public Supplier findSupplierByUserId(Integer userId) {
    return supplierDao.findSupplierByUserId(userId);
  }

  public SupplierDao getSupplierDao() {
    return supplierDao;
  }

  public void setSupplierDao(SupplierDao supplierDao) {
    this.supplierDao = supplierDao;
  }

  public void updateSupplierProfile(Supplier supplier) {
    supplierDao.updateSupplierProfile(supplier);
  }

  /**
   * 获取厂家认证状态
   * 
   * @param user_Id
   * @return String
   */
  @Override
  public String getCertifiedType(int i) {
    String certified_type = userDao.findSupplierCertifiedTypeById(i);
    String certifiedType = "";
    switch (certified_type) {
    case "0":
      certifiedType = "未认证";
      break;
    case "1":
      certifiedType = "初级认证";
      break;
    case "2":
      certifiedType = "高级认证";
      break;
    }
    // String certifiedType = "未认证1";
    return certifiedType;
  }

  @Override
  public void updateLable(HashMap<String, Object> map) {
    userDao.updateLable(map);
  }

  /**
   * 获取厂家最近一周发布新款情况
   * 
   * @param user_Id
   * @return integer
   */
  @Override
  public int getWeekPublish(int i) {
    int weekPublish = userDao.findWeekPublishById(i);
    return weekPublish;
  }

  /**
   * 获取厂家最近一周被发布到淘宝的产品数量
   * 
   * @param user_Id
   * @return integer
   */
  @Override
  public int getWeekTaobao(int i) {
    return 0;
  }

  /**
   * 获取厂家最近一周被下载的产品数量
   * 
   * @param user_Id
   * @return integer
   */
  public int getWeekDownload(int i) {
    return 0;
  }

  /**
   * 获取最近90天下载或发布过该厂家产品的卖家数量
   * 
   * @param user_Id
   * @return integer
   */
  public int getNinetySeller(int i) {
    return 0;
  }

  /**
   * 获取所有发布过该厂家产品的卖家数
   * 
   * @param user_Id
   * @return integer
   */
  public int getAllSeller(int i) {
    return 0;
  }

  @Override
  public PageInfo<HashMap<Object, Object>> vipDownload(int supplierId, Pagination pagination) {
    PageHelper.startPage(pagination.getPageNum(), pagination.getPageSize());
    List<HashMap<Object, Object>> l = supplierDao.vipUserDownload(supplierId);
    PageInfo<HashMap<Object, Object>> pi = new PageInfo<HashMap<Object, Object>>(l, pagination.getNavigationSize());

    return pi;
  }

  @Override
  public PageInfo<HashMap<Object, Object>> productDownload(int supplierId, Pagination pagination) {
    PageHelper.startPage(pagination.getPageNum(), pagination.getPageSize());
    List<HashMap<Object, Object>> list = supplierDao.productDownload(supplierId);
    PageInfo<HashMap<Object, Object>> pi = new PageInfo<HashMap<Object, Object>>(list, pagination.getNavigationSize());
    return pi;
  }

  @Override
  public PageInfo<HashMap<Object, Object>> taobaoProductPublish(int supplierId, Pagination pagination) {
    PageHelper.startPage(pagination.getPageNum(), pagination.getPageSize());
    List<HashMap<Object, Object>> list = supplierDao.taobaoProductPublish(supplierId);
    PageInfo<HashMap<Object, Object>> pi = new PageInfo<HashMap<Object, Object>>(list, pagination.getNavigationSize());
    return pi;
  }

  @Override
  public void getDownloadedProducts(Integer userId, String year) {
    // TODO Auto-generated method stub

  }

  @Override
  public PageInfo getSupplierByCondition(Integer marketId, String capital, Integer sort, String keyword, Pagination pagination) {
    PageHelper.startPage(pagination.getPageNum(), pagination.getPageSize());
    List<Supplier> supplierList = supplierDao.getSupplierByCondition(marketId, capital, sort, keyword);

    for (Supplier supplier : supplierList) {
      List<Product> products = productDao.getProductsBySupplierId(supplier.getUserId());
      supplier.setProducts(products);
    }

    PageInfo pi = new PageInfo(supplierList, pagination.getNavigationSize());

    return pi;
  }

  @Override
  public List<Supplier> getCapitalByCondition(Integer marketId, String keyword) {
    List<Supplier> capitalList = supplierDao.getCapitalByCondition(marketId, keyword);

    for (Supplier capital : capitalList) {
      if (capital.getCapital().equals("9")) {
        capital.setCapital("0-9");
      }
    }

    return capitalList;
  }

  /**
   * 将分数转化成等级
   * 
   * @param supplier
   * @return 商家等级
   */
  @Override
  public Integer converteScoreToLevel(Integer score) {

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

  @Override
  public List<SupplierCreditNew> scoreDetail(Integer userId) {
    return supplierDao.scoreDetail(userId);
  }

  @Override
  public List<ScoreCategory> getScoreCategory() {
    return supplierDao.getScoreCategory();
  }

  @Override
  public List<SupplierCreditNew> getScoreTotal(Integer userId) {
    // TODO 积分详情
    return supplierDao.getScoreTotal(userId);
  }

  @Override
  public SupplierRank getRankByUserId(Integer userId) {
    return supplierDao.getSupplierRankByUserId(userId);
  }

}
