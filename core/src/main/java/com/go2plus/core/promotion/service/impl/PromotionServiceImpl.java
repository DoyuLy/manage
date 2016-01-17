package com.go2plus.core.promotion.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.go2plus.common.mvc.Pagination;
import com.go2plus.core.portal.dao.PortalDao;
import com.go2plus.core.product.vo.Product;
import com.go2plus.core.promotion.dao.PromotionDao;
import com.go2plus.core.promotion.service.PromotionService;
import com.go2plus.core.promotion.vo.AdPosition;
import com.go2plus.core.promotion.vo.MyPromotion;
import com.go2plus.core.promotion.vo.Promotion;

@Service
public class PromotionServiceImpl implements PromotionService {
  @Resource
  private PortalDao    portalDao;
  @Resource
  private PromotionDao promotionDao;

  @Override
  public List<Promotion> getSponsers(String pos, Integer[] excludes) {
    return promotionDao.getSponsers(pos, excludes);
  }

  public PromotionDao getPromotionDao() {
    return promotionDao;
  }

  public void setPromotionDao(PromotionDao promotionDao) {
    this.promotionDao = promotionDao;
  }

  public List<Promotion> getGrabFPs() {
    List<Promotion> grabFPs = this.promotionDao.getGrabFPs();
    return grabFPs;
  }

  public int getPromotion(String userId, String id) {
    return this.promotionDao.getPromotion(userId, id);
  }

  public List<Product> getMyProduct(String userId) {
    return this.promotionDao.getMyProduct(userId);
  }

  public List<MyPromotion> getMyPromotion(String userId) {
    return this.promotionDao.getMyPromotion(userId);
  }

  public int setPromotion(String productId, String promotionId) {
    return this.promotionDao.setPromotion(productId, promotionId);
  }

  @Override
  public List<Promotion> getPDSponsors() {
    return promotionDao.queryPromotions(new int[] { 8329, 8330 });
  }

  @Override
  public List<Promotion> getBanners() {
    System.out.println("............");
    List<Promotion> banners = portalDao.getBanners();
    return banners;
  }

  @Override
  public List<Promotion> getCurPromotions() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Promotion> getSelections() {
    List<Promotion> selections = portalDao.getSelections();
    return selections; 
  }

  @Override
  public List<Product> getCthPromotions() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public PageInfo getUniqueProduct(String categoryId, int sortId, Pagination pagination) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Promotion getCancelPromotion(int id) {
    return promotionDao.getCancelPromotion(id);
  }

  @Override
  public int updatePromotion(int id) {
    return promotionDao.updatePromotion(id);
  }

  @Override
  public int addAD(AdPosition adPosition) {
    return promotionDao.addAD(adPosition);
  }
}
