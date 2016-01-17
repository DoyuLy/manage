package com.go2plus.core.publish.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.go2plus.core.publish.vo.LogDownload;
import com.go2plus.common.mvc.DAO;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * LogDownloadDao Dao
 * 
 * 卖家的商品下载记录
 * 
 * @author yuyanlin
 * @since 2015-11-03
 */
@Service
public interface LogDownloadDao extends DAO {

  /**
   * 根据用户Id和表名获取下载记录
   * 
   * @param userId
   * @param table
   * @return
   */
  public List<LogDownload> getLogDownloads(Integer userId, String table);
  
  /**
   * 根据Id软删除下载记录
   * @param ids
   * @return 
   */
  public int delLogDownload(@Param("ids") String[] ids);

  /**
   * 根据ids数组删除多个下载记录
   * 
   * @param ids
   * @param table
   */
  public void delMultiDownload(int[] ids, String table);
  /**
   * 产品下载列表
   * @param productId
   * @return
   */
  public List<LogDownload> getDownloadList(int productId);
  
}
