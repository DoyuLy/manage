package com.go2plus.core.common.web.controller;

import java.io.Serializable;

import com.go2plus.core.common.entity.AbstractEntity;

/**
 * <p>Description: 
 * <p>User: mtwu
 * <p>Date: 2015-12-21
 * <p>Version: 1.0
 */
public abstract class BaseCRUDController <M extends AbstractEntity, ID extends Serializable> {
      
  /**
   * 无法抽象BaseCRUDController,  Service层没有实现一个公用的接口 
   */
  //private abstract getEntityService();
}
