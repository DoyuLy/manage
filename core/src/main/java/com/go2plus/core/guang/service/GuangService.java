
package com.go2plus.core.guang.service;

import java.util.HashMap;
import java.util.List;

import com.go2plus.core.guang.vo.Guang;
/**
Copyright (C) 2015 GO2.CN. All rights reserved.
This computer program source code file is protected by copyright
law and international treaties. Unauthorized distribution of source code files,
programs, or portion of the package, may result in severe civil and criminal
penalties, and will be prosecuted to the maximum extent under the law.
GuangService
@author liyang
*/
public interface GuangService {

  /**
   * 根据条件查询逛逛列表，条件参数封装到guang对象里
   * @param guang
   * @return List<Guang>
   */
  public List<Guang> getGuangProductList(Guang guang,String user_id);
  
  /**
   * 按条件查询逛逛的总数
   * @param guang
   * @return int型的逛逛总数
   */
  public Integer getGuangProductTotal(Guang guang);
  
  /**
   * 查询当季热卖的数量
   * @return 返回一个map,对应每种的数量
   */
  public HashMap<String,String> getCountCategorys();
  
  /**
   * 逛逛喜欢存入redis
   * @param user_id
   * @param id
   * @return 返回喜欢数量 
   */
  public int saveGuangLike(String user_id,int productId);
  /**
   * 流行元素转化
   * @param props
   * @return 流行元素
   */
  public String propsCase(String props);
}
