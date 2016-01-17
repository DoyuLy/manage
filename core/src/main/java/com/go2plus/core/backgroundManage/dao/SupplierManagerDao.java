package com.go2plus.core.backgroundManage.dao;

import java.sql.Blob;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.go2plus.common.mvc.DAO;
import com.go2plus.core.product.vo.Product;
import com.go2plus.core.product.vo.ProductMeta;

@Repository
public interface SupplierManagerDao extends DAO {

  /**
   * 获得上架产品信息
   * 
   * @param supplier
   * @param productId
   * @return
   * @return
   */

  Product getOneProduct(@Param("supplierId") int supplierId, @Param("productId") int productId);

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
  int saveProductDescriptionBlob(@Param("productId") String productId, @Param("descriptionBlob") Blob descriptionBlob);

}
