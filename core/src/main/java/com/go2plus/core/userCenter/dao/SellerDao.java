package com.go2plus.core.userCenter.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.go2plus.common.mvc.DAO;
import com.go2plus.core.publish.vo.AliItem;
import com.go2plus.core.publish.vo.LogDownload;
import com.go2plus.core.publish.vo.TaobaoItem;
import com.go2plus.core.userCenter.vo.ComplainCategory;
import com.go2plus.core.userCenter.vo.InSeller2Product;
import com.go2plus.core.userCenter.vo.SellerBlackList;
import com.go2plus.core.userCenter.vo.SellerFavorite;
import com.go2plus.core.userCenter.vo.Supplier;
import com.go2plus.core.userCenter.vo.User;

public interface SellerDao extends DAO {

  /**
   * 获取卖家下载记录
   * 
   * @param userId
   * @param year
   */
  public void getDownloadedProducts(Integer userId, String year);

  /**
   * 在阿里的产品
   * 
   * @param userId
   * @return
   */
  public List<AliItem> getAliItem(@Param("userId") Integer userId,@Param("aliNick") String aliNick);

  /**
   * 在淘宝的产品
   * 
   * @param userId
   * @param taobaoNick
   * @return
   */
  public List<TaobaoItem> getTaobaoItem(Integer userId, String taobaoNick);

  /**
   * 删除在淘宝的产品
   * 
   * @param numId
   * @param table
   */
  public int delTaobaoItem(@Param("id") int id, @Param("table") String table);

  /**
   * 删除在阿里的商品
   * 
   * @param offerid
   * @return
   */
  public int delAliItem(@Param("id") String id);

  /**
   * 黑名单管理
   */

  /**
   * 插入黑名单
   * 
   * @param sellerBlackList
   * @return
   */
  int saveSellerBlackList(SellerBlackList sellerBlackList);

  /**
   * 查询黑名单
   * 
   * @param sellerId
   * @return
   */
  public List<SellerBlackList> selectSellerBlackList(String sellerId);

  /**
   * 查询淘宝卖家发布的厂家列表
   * 
   * @param joinedSellerBlackList
   * @return
   */
  public List<InSeller2Product> querySellerPublishSupplier(@Param("sellerId") String sellerId,
      @Param("joinedSellerBlackList") List<String> joinedSellerBlackList);

  /**
   * 已加入到卖家黑名单的厂家id
   * 
   * @param sellerId
   * @return 黑名单厂家
   */
  public List<String> queryJoinedBlackListSupplierId(String sellerId);

  /**
   * 查询卖家加黑原因
   * 
   * @return
   */
  public List<ComplainCategory> queryAddBlackListReason();

  public int deleteSellerBlackList(String Id);

  /**
   * 下载过的厂家
   * 
   * @param userId
   * @return
   */
  public List<LogDownload> getDownloadSupplier(Integer userId);

  /**
   * 卖家关注
   * 
   * @param userId
   * @return
   */
  List<SellerFavorite> getSellerFavorite(Integer userId);
}
