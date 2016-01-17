package com.go2plus.core.userCenter.dao;

import org.apache.ibatis.annotations.Param;

import com.go2plus.common.mvc.DAO;
/**
Copyright (C) 2015 GO2.CN. All rights reserved.
This computer program source code file is protected by copyright
law and international treaties. Unauthorized distribution of source code files,
programs, or portion of the package, may result in severe civil and criminal
penalties, and will be prosecuted to the maximum extent under the law.
@author liyang
*/
public interface SupplierStatsDao extends DAO{

  /**
   * 获取厂家的关联产品限制数量
   * @return
   */
  int getHighlightLimitByUserId(@Param("userId") int userId);
}
