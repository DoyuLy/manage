package com.go2plus.core.publish.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.go2plus.common.mvc.Pagination;
import com.go2plus.core.publish.dao.LogDownloadDao;
import com.go2plus.core.publish.service.LogDownloadService;
import com.go2plus.core.publish.vo.LogDownload;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * LogDownloadServiceImpl Service Impl
 * 
 * @author yuyanlin
 * @since 2015-11-03
 */

@Service
public class LogDownloadServiceImpl implements LogDownloadService {
  
  @Resource
  private LogDownloadDao logDownloadDao;
  @Override
  public PageInfo getLogDownloads(Integer userId, String table, Pagination pagination) {
    
    PageHelper.startPage(pagination.getPageNum(),pagination.getPageSize());
    
    List<LogDownload> list = logDownloadDao.getLogDownloads(userId, table);
    
    PageInfo pi = new PageInfo(list, pagination.getNavigationSize());
    
    return pi;
  }
  @Override
  public int  delLogDownload(String[] ids ) {
    return logDownloadDao.delLogDownload(ids);
  }

  @Override
  public void delMultiDownload(int[] ids, String table) {
    logDownloadDao.delMultiDownload(ids, table);
  }

}
