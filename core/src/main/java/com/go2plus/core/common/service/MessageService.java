package com.go2plus.core.common.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.go2plus.common.mvc.Pagination;
import com.go2plus.core.common.vo.Message;

public interface MessageService {
  /**
   * 保存厂家消息
   * 
   * @param userId
   * @param content
   */
  public int saveUserMessage(Message message);

  /**
   * 显示厂家消息
   * 
   * @param userId
   * @return
   */
  public List<Message> showLastMessage(int userId);
  /**
   * 2B端显示
   * 
   */


  //产品公告
  PageInfo<Message> querySellerProductNotice(String sellerId, Pagination pagination);

  public PageInfo querySellerSupplierNotice(String sellerId, Pagination pagination);
  /**
   * 获取前5条厂家公告
   * @param userId
   * @return
   */
  public List<Message> queryBySupplier(int userId);
}
