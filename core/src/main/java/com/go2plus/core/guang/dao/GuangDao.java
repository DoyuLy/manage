
package com.go2plus.core.guang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.go2plus.common.mvc.DAO;
import com.go2plus.core.guang.vo.Guang;
/**
Copyright (C) 2015 GO2.CN. All rights reserved.
This computer program source code file is protected by copyright
law and international treaties. Unauthorized distribution of source code files,
programs, or portion of the package, may result in severe civil and criminal
penalties, and will be prosecuted to the maximum extent under the law.
逛逛dao
@author liyang
*/
@Repository
public interface GuangDao extends DAO {

  /**
   * 根据条件查询逛逛列表，条件参数封装到guang对象里
   * @param guang
   * @return List<Guang>逛逛列表
   */
  public List<Guang> getGuangProductList(Guang guang);
  /**
   * 按条件查询逛逛的总数
   * @param guang
   * @return int型的逛逛总数
   */
  public Integer getGuangProductTotal(Guang guang);
  /**
   * 按条件查询逛逛的总数
   * @param guang
   * @return int型的逛逛总数
   */
  public Integer getCountEveryCategory(@Param("category") String category);
}

