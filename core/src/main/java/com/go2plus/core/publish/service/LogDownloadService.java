package com.go2plus.core.publish.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.go2plus.common.mvc.Pagination;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * LogDownloadService Service
 * 
 * @author yuyanlin
 * @since 2015-11-03
 */

public interface LogDownloadService {
  
  /**
   * 根据用户Id和表名获取下载记录
   * 
   * @param userId
   * @param table
   * @return
   */
  public PageInfo getLogDownloads(Integer userId, String table, Pagination pagination);

  /**
   * 根据Id软删除下载记录
   * @param logDownloadId
   */
  public int delLogDownload(String[] ids);
  
  /**
   * 根据ids数组删除多个下载记录
   * 
   * @param ids
   * @param table
   */
  public void delMultiDownload(int[] ids, String table);

}
