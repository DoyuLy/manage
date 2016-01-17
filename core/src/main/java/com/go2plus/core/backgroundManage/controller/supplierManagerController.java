package com.go2plus.core.backgroundManage.controller;

import java.sql.Blob;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.go2plus.common.X;
import com.go2plus.common.mvc.BaseController;
import com.go2plus.common.mvc.Box;
import com.go2plus.core.backgroundManage.service.SupplierManagerService;
import com.go2plus.core.product.vo.Product;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * 卖家中心后台管理
 * 
 * 
 * @author gaozhenghua
 * @since 2016-01-4
 */
@Controller
public class supplierManagerController extends BaseController {
  private final static Logger    logger = LoggerFactory.getLogger(supplierManagerController.class);
  @Resource
  private SupplierManagerService supplierManagerService;

  /**
   * 编辑上架商品信息
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = "/manage/supplier/editProduct/{productId}")
  public ModelAndView editProduct(@PathVariable("productId") String productId, HttpServletRequest request, HttpServletResponse response) {
    logger.debug("supplierManagerController.editProduct()");
    Box box = loadNewBox(request);
    // 查询供应商信息
    String supplierId = box.$cv(X.USER);

    // 发布和下载
    Product product = supplierManagerService.getOneProduct(Integer.parseInt(supplierId), Integer.parseInt(productId));
    box.setAttribute("product", product);
    // 判断该产品是否正报名活动
    // boolean isApply = specialTopicService.getApplyInfo(productId);
    boolean isApply = false;
    box.setAttribute("isApply", isApply);
    // 厂家相关数据

    return createModelAndView("/backgroundManage/supplier/editProduct.jsp", box);

  }

  /**
   * 保存产品编辑页
   * 
   * @param productId
   * @param request
   * @param response
   * @return
   */

  @RequestMapping(value = "/manage/supplier/saveEditProduct/{productId}")
  @ResponseBody
  public String saveProduct(@PathVariable("productId") String productId, HttpServletRequest request, HttpServletResponse response)
      throws SerialException {
    Box box = loadNewBox(request);
    String isHideStats = box.$p("is_hide_stats");
    String articleNumber = box.$p("checkArticleNumber");
    String characters = box.$p("characters");
    String size = box.$p("size");
    // String indexImage = box.$p("indexImage");
    String price = box.$p("price");
    String file = box.$p("rar_focus");
    // 组装对象
    if (productId == "" || productId == null) {
      productId = "0";
    }
    Product product = new Product();
    product.setId(Integer.parseInt(productId));
    product.setIsHideStats(Integer.parseInt(isHideStats));
    product.setArticleNumber(articleNumber);
    product.setCharacters(characters);
    product.setSize(size);
    // product.setIndexImage(indexImage);
    product.setPrice(Double.parseDouble(price));
    product.setFile(file);
    // 保存修改数据
    int cnt = supplierManagerService.savaProductEdit(product);
    // 保存产品详情页
    String descriptionHtml = request.getParameter("fullHtml").replaceAll("http://content.ximgs.net", "");
    // 将String转为MySQLblob类型
    Blob descriptionBlob = null;
    try {
      descriptionBlob = new SerialBlob(descriptionHtml.getBytes());
    } catch (SQLException e) {
      e.printStackTrace();
    }

    int count = supplierManagerService.saveProductDescriptionBlob(productId, descriptionBlob);
    // 当同时更新product和product_meta表成功时，才显示成功消息
    int result = cnt & count;
    return Integer.toString(result);

  }
}
