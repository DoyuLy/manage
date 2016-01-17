package com.go2plus.core.userCenter.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.go2plus.common.mvc.Pagination;
import com.go2plus.core.publish.vo.AliItem;
import com.go2plus.core.publish.vo.LogDownload;
import com.go2plus.core.publish.vo.TaobaoItem;
import com.go2plus.core.userCenter.dao.SellerDao;
import com.go2plus.core.userCenter.service.SellerService;
import com.go2plus.core.userCenter.vo.ComplainCategory;
import com.go2plus.core.userCenter.vo.InSeller2Product;
import com.go2plus.core.userCenter.vo.SellerBlackList;
import com.go2plus.core.userCenter.vo.SellerFavorite;

@Service
public class SellerServiceImpl implements SellerService {

  @Resource
  private SellerDao sellerDao;

  public void getDownloadedProducts(Integer userId, String year) {
    sellerDao.getDownloadedProducts(userId, year);
  }

  public SellerDao getSellerDao() {
    return sellerDao;
  }

  public void setSellerDao(SellerDao sellerDao) {
    this.sellerDao = sellerDao;
  }

  @Override
  public PageInfo getAliItem(Integer userId, String aliNick, Pagination pagination) {
    PageHelper.startPage(pagination.getPageNum(), pagination.getPageSize());
    List<AliItem> list = sellerDao.getAliItem(userId, aliNick);
    PageInfo pi = new PageInfo(list, pagination.getNavigationSize());

    return pi;
  }

  @Override
  public PageInfo getTaobaoItem(Integer userId, String taobaoNick, Pagination pagination) {
    PageHelper.startPage(pagination.getPageNum(), pagination.getPageSize());
    List<TaobaoItem> list = sellerDao.getTaobaoItem(userId, taobaoNick);
    PageInfo pi = new PageInfo(list, pagination.getNavigationSize());

    return pi;
  }

  @Override
  public int delTaobaoItem(int id, String table) {
   return sellerDao.delTaobaoItem(id, table);
  }

  @Override
  public int delAliItem(String id) {

   return sellerDao.delAliItem(id);

  }

  public int insertSupplierBlackList(SellerBlackList sellerBlackList) {
    return sellerDao.saveSellerBlackList(sellerBlackList);
  }

  public PageInfo selectSellerBlackList(String sellerId, Pagination pagination) {
    PageHelper.startPage(pagination.getPageNum(), pagination.getPageSize());
    List<SellerBlackList> list = sellerDao.selectSellerBlackList(sellerId);

    PageInfo pi = new PageInfo(list, pagination.getNavigationSize());
    return pi;
  }

  @Override
  public int saveSellerBlackList(SellerBlackList sellerBlackList) {
    return sellerDao.saveSellerBlackList(sellerBlackList);
  }

  @Override
  public List<InSeller2Product> querySellerBlackListOptionSupplier(String sellerId) {
    List<String> joinedSellerBlackList = sellerDao.queryJoinedBlackListSupplierId(sellerId);
    return sellerDao.querySellerPublishSupplier(sellerId, joinedSellerBlackList);
  }

  @Override
  public List<ComplainCategory> queryAddBlackListOptionReason() {
    return sellerDao.queryAddBlackListReason();
  }

  @Override
  public int deleteSellerBlackList(String Id) {
    return sellerDao.deleteSellerBlackList(Id);
  }

  public PageInfo getDownloadSupplier(Integer userId, Pagination pagination) {
    PageHelper.startPage(pagination.getPageNum(), pagination.getPageSize());
    List<LogDownload> list = sellerDao.getDownloadSupplier(userId);
    PageInfo pi = new PageInfo(list, pagination.getNavigationSize());
    return pi;
  }

  @Override
  public PageInfo getSellerFavorite(Integer userId, Pagination pagination) {
    PageHelper.startPage(pagination.getPageNum(), pagination.getPageSize());

    List<SellerFavorite> list = sellerDao.getSellerFavorite(userId);

    PageInfo pi = new PageInfo(list, pagination.getNavigationSize());

    return pi;
  }
}
