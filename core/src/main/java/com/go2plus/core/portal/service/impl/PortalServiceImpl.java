package com.go2plus.core.portal.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.go2plus.common.mvc.Pagination;
import com.go2plus.core.portal.dao.PortalDao;
import com.go2plus.core.portal.service.PortalService;
import com.go2plus.core.product.dao.ProductDao;
import com.go2plus.core.product.vo.Product;
import com.go2plus.core.promotion.vo.Promotion;

@Service
public class PortalServiceImpl implements PortalService {

  @Resource
  PortalDao portalDao;
  @Resource
  ProductDao productDao;
  
  @Override
  public List<Promotion> getBanners() {
    List<Promotion> banners = portalDao.getBanners();
    return banners;
  }

  @Override
  public List<Promotion> getPromotions() {
    List<Promotion> promotions = portalDao.getPromotions();
    return promotions;
  }

  @Override
  public List<Promotion> getSelections() {
    List<Promotion> selections = portalDao.getSelections();
    return selections;
  }
  @Override
  public List<Product> getCthPromotions() {
    return portalDao.getCthPromotions();
  }

  @Override
  public PageInfo getUniqueProduct(String categoryId, int sortId, Pagination pagination) {
    PageHelper.startPage(pagination.getPageNum(), pagination.getPageSize());
    List<Product> list = productDao.getUniqueProduct(categoryId, sortId);
    PageInfo pi = new PageInfo<>(list, pagination.getNavigationSize());
    return pi;
  }

  @Override
  public List<Promotion> getCurPromotions() {
    List<Promotion> promotions = portalDao.getCurPromotions();
    return promotions;
  }
  
  
}
