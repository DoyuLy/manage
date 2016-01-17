package com.go2plus.core.backgroundManage.service.impl;

import java.sql.Blob;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.go2plus.common.img.ImgAddressConvert;
import com.go2plus.core.backgroundManage.dao.SupplierManagerDao;
import com.go2plus.core.backgroundManage.service.SupplierManagerService;
import com.go2plus.core.product.vo.Product;
import com.go2plus.core.product.vo.ProductMeta;

@Service
public class SupplierManagerServiceImpl implements SupplierManagerService {

  @Resource
  private SupplierManagerDao supplierManagerDao;

  @Override
  public Product getOneProduct(int supplierId, int productId) {
    Product product = supplierManagerDao.getOneProduct(supplierId, productId);
    String productDesc = product.getProductMeta().getDescriptionBin();
    // 将相对地址替换为绝对地址
    String newProductDesc = ImgAddressConvert.editedProductAddrConvert(productDesc);
    ProductMeta productMeta = new ProductMeta();
    productMeta.setDescriptionBin(newProductDesc);
    // 修改描述
    product.setProductMeta(productMeta);
    return product;
  }

  @Override
  public int savaProductEdit(Product product) {
    return supplierManagerDao.savaProductEdit(product);
  }

  @Override
  public int saveProductDescriptionBlob(String productId, Blob descriptionBlob) {
    return supplierManagerDao.saveProductDescriptionBlob(productId, descriptionBlob);
  }

}
