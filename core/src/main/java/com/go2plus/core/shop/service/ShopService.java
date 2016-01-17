package com.go2plus.core.shop.service;

/**
Copyright (C) 2015 GO2.CN. All rights reserved.
This computer program source code file is protected by copyright
law and international treaties. Unauthorized distribution of source code files,
programs, or portion of the package, may result in severe civil and criminal
penalties, and will be prosecuted to the maximum extent under the law.
*/
import com.go2plus.core.userCenter.vo.Supplier;

public interface ShopService {
  /**
   * 根据用户id查询供货商
   * @param supplierId
   * @return 供货商对象
   */
  public Supplier findSupplierByUserId(int supplierId);

}
