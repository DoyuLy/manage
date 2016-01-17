package com.go2plus.core.supplier.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.go2plus.core.userCenter.dao.SupplierDao;
import com.go2plus.core.userCenter.vo.Supplier;

public class SupplierDaoTest {
  private static SupplierDao sd;

  @BeforeClass
  public static void setup() {
    ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:IOC.xml");
    sd = (SupplierDao) ac.getBean("supplierDao");

    assertNotNull(sd);
  }
  
  @Test
  public void testGetSupplierByCondition() {
    try {
      List<Supplier> supplier = sd.getSupplierByCondition(99, "M", 2, "");
      assertNotNull(supplier);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Test
  public void testGetCapitalByCondition() {
    try {
      List<Supplier> supplierList = sd.getCapitalByCondition(6, "");
      assertNotNull(supplierList);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Test
  public void findSupplierByUserId() {
    try {
      Supplier supplier = sd.findSupplierByUserId(68);
      assertNotNull(supplier);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
