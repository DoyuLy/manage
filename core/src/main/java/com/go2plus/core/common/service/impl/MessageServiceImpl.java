package com.go2plus.core.common.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.go2plus.common.mvc.Pagination;
import com.go2plus.core.common.dao.MessageDao;
import com.go2plus.core.common.service.MessageService;
import com.go2plus.core.common.vo.Message;

@Service
public class MessageServiceImpl implements MessageService {

  @Resource
  private MessageDao messageDao;

  public MessageDao getMessageDao() {
    return messageDao;
  }

  public void setMessageDao(MessageDao messageDao) {
    this.messageDao = messageDao;
  }

  /**
   * 保存用户发送的消息
   */
  @Override
  public int saveUserMessage(Message message) {
    return messageDao.insertUserMessage(message);

  }

  /**
   * 显示消息
   * 
   * @param sellerId
   * @return 最新消息
   */

  @Override
  public List<Message> showLastMessage(int userId) {
    return messageDao.queryLastMessage(userId);
  }

  /**
   * 产品公告
   * 
   * @param sellerId
   * @return 产品公告列表
   */
  @Override
  public PageInfo querySellerProductNotice(String sellerId, Pagination pagination) {
    PageHelper.startPage(pagination.getPageNum(), pagination.getPageSize());
    List<Message> list = messageDao.querySellerProductNotice(sellerId);
    PageInfo pi = new PageInfo(list, pagination.getNavigationSize());
    return pi;
  }

  /**
   * 厂家公告
   * 
   * @param sellerId
   * @return 厂家公告列表
   */
  @Override
  public PageInfo querySellerSupplierNotice(String sellerId, Pagination pagination) {
    PageHelper.startPage(pagination.getPageNum(), pagination.getPageSize());
    List<Message> list = messageDao.querySellerSupplierNotice(sellerId);
    PageInfo pi = new PageInfo(list, pagination.getNavigationSize());
    return pi;
  }
  @Override
  public List<Message> queryBySupplier(int userId) {
    return messageDao.queryBySupplier(userId);
  }
}
