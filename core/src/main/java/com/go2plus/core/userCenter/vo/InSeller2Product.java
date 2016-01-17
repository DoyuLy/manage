package com.go2plus.core.userCenter.vo;



public class InSeller2Product {
  private String   sellerUserId;
  private String   productId;
  private String   supplierUserId;
  private Supplier supplier;

  public Supplier getSupplier() {
    return supplier;
  }

  public void setSupplier(Supplier supplier) {
    this.supplier = supplier;
  }

  public String getSellerUserId() {
    return sellerUserId;
  }

  public void setSellerUserId(String sellerUserId) {
    this.sellerUserId = sellerUserId;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public String getSupplierUserId() {
    return supplierUserId;
  }

  public void setSupplierUserId(String supplierUserId) {
    this.supplierUserId = supplierUserId;
  }

}
