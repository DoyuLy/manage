package com.go2plus.core.page.dao;

import com.go2plus.core.page.vo.Page;
import com.go2plus.common.mvc.DAO;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * PageDao
 * 
 * @author yuyanlin
 * @since 2015-11-03
 */

public interface PageDao extends DAO {
  
  /**
   * 
   * 根据userId 和 "服务承诺 " 查找对应的服务承诺
   * 
   * @param userId
   * @return Page
   */
  public Page findPageByUserIdAndFwcn(int userId);
  
  /**
   * 
   * 更新服务承诺之类的信息
   * 
   * @param page
   */
  public void updatePageByUserIdAndFwcn(Page page);
  
  /**
   * 
   * 新增服务承诺之类的信息
   * 
   * @param page
   */
  public void insertPage(Page page);
}
