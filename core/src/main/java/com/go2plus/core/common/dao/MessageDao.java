package com.go2plus.core.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.go2plus.common.mvc.DAO;
import com.go2plus.core.common.vo.Message;

public interface MessageDao extends DAO {
  /**
   * 插入用户发布的信息
   * 
   * @param message
   * @return
   */
  int insertUserMessage(Message message);

  // 查询供应商最新消息
  List<Message> queryLastMessage(int supplierIds);

  // 查询淘宝卖家产品消息
  List<Message> querySellerProductNotice(String sellerId);

  List<Message> querySellerSupplierNotice(String sellerId);

  /**
   * 获得公司简介
   * 
   * @param supplierId
   * @return
   */
  String getPageContent(int supplierId);
  /**
   * 获取厂家公告
   * 
   * @param userId
   * @return
   */
  List<Message> queryBySupplier(@Param("userId") int userId);
}
