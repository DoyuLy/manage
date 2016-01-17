package com.go2plus.core.product.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.go2plus.core.product.vo.Product;

public class ProductDaoTest {

  private static ProductDao productDao;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:IOC.xml");
    productDao = (ProductDao) ac.getBean("productDao");

    assertNotNull(productDao);
  }

  @Test
  public void testGetProductsBySupplierId() {
    try {
      List<Product> productList = productDao.getProductsBySupplierId(32434);
      assertNotNull(productList);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testGetAllProduct() {
    try {
      List<Product> productList = productDao.getAllProduct();
      assertNotNull(productList);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
