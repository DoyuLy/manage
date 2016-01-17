package com.go2plus.core.userCenter.service;

import java.util.HashMap;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.go2plus.common.mvc.Pagination;
import com.go2plus.core.publish.vo.LogDownload;
import com.go2plus.core.userCenter.vo.ComplainCategory;
import com.go2plus.core.userCenter.vo.InSeller2Product;
import com.go2plus.core.userCenter.vo.SellerBlackList;
import com.go2plus.core.userCenter.vo.Supplier;
import com.go2plus.core.userCenter.vo.User;

public interface SellerService {

  /**
   * 在阿里的产品
   * 
   * @param userId
   * @return
   */
  public PageInfo getAliItem(Integer userId, String aliNick, Pagination pagination);

  /**
   * 在淘宝的产品
   * 
   * @param userId
   * @param taobaoNick
   * @return
   */
  public PageInfo getTaobaoItem(Integer userId, String taobaoNick, Pagination pagination);

  /**
   * 删除在淘宝的商品
   * 
   * @param numId
   * @param table
   * @return 
   */
  public int delTaobaoItem(int id, String table);

  /**
   * 删除在阿里的商品
   * 
   * @param offerid
   * @return 
   */
  public int delAliItem(String offerid);

  /**
   * 黑名单管理
   * 
   * @param pagination
   * 
   */

  // 显示黑名单
  public PageInfo selectSellerBlackList(String sellerId, Pagination pagination);

  /**
   * 下载过的厂家
   * 
   * @param userId
   * @return
   */
  public PageInfo getDownloadSupplier(Integer userId, Pagination pagination);

  /**
   * 添加黑名单
   * 
   * @param sellerBlackList
   * @return
   */
  public int saveSellerBlackList(SellerBlackList sellerBlackList);

  // 查询加黑原因
  public List<InSeller2Product> querySellerBlackListOptionSupplier(String sellerId);

  public List<ComplainCategory> queryAddBlackListOptionReason();

  // 删除厂家黑名单
  public int deleteSellerBlackList(String Id);

  /**
   * 根据用户id查询2B关注
   * 
   * @param userId
   * @param pagination
   * @return
   */
  public PageInfo getSellerFavorite(Integer userId, Pagination pagination);

}
