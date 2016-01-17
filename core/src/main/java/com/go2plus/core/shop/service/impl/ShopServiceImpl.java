package com.go2plus.core.shop.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.go2plus.core.shop.service.ShopService;
import com.go2plus.core.userCenter.service.SupplierService;
import com.go2plus.core.userCenter.vo.Supplier;
/**
Copyright (C) 2015 GO2.CN. All rights reserved.
This computer program source code file is protected by copyright
law and international treaties. Unauthorized distribution of source code files,
programs, or portion of the package, may result in severe civil and criminal
penalties, and will be prosecuted to the maximum extent under the law.
*/
@Service
public class ShopServiceImpl implements ShopService {
  @Resource
  private SupplierService supplierService;

  /**
   * 根据URL地址查找供应商信息
   */
  @Override
  public Supplier findSupplierByUserId(int supplierId) {
    return supplierService.findSupplierByUserId(supplierId);
  }
}
