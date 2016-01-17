package com.go2plus.core.backgroundManage.service;

import java.sql.Blob;

import com.go2plus.core.product.vo.Product;
import com.go2plus.core.product.vo.ProductMeta;

public interface SupplierManagerService {

  /**
   * 获得上架产品信息
   * 
   * @param supplier
   * @param i
   * @return
   */
  Product getOneProduct(int supplierId, int productId);

  /**
   * 保存产品编辑数据
   * 
   * @param product
   * @return
   */
  int savaProductEdit(Product product);
  /**
   * 保存产品编辑详情页
   * 
   * @param product
   * @return
   */
  int saveProductDescriptionBlob(String productId, Blob descriptionBlob);

}
