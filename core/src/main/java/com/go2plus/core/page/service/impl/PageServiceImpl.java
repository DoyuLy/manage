package com.go2plus.core.page.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.go2plus.core.page.service.PageService;
import com.go2plus.core.page.vo.Page;
import com.go2plus.core.page.dao.PageDao;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * PageServiceImpl Service Impl
 * 
 * @author yuyanlin
 * @since 2015-11-03
 */

@Service
public class PageServiceImpl implements PageService {
  private Page page;
  
  @Resource
  private PageDao pageDao;
  
  public Page findPageByUserIdAndFwcn(Integer userId) {
    return pageDao.findPageByUserIdAndFwcn(userId);
  }
  
  public void updatePageByUserIdAndFwcn(Page page) {
    pageDao.updatePageByUserIdAndFwcn(page);
  }
  
  public void insertPage(Page page) {
    pageDao.insertPage(page);
  }
}
