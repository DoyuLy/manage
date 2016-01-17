package com.go2plus.core.seller.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.go2plus.core.publish.vo.AliItem;
import com.go2plus.core.publish.vo.LogDownload;
import com.go2plus.core.publish.vo.TaobaoItem;
import com.go2plus.core.userCenter.dao.SellerDao;
import com.go2plus.core.userCenter.vo.InSeller2Product;
import com.go2plus.core.userCenter.vo.SellerBlackList;
import com.go2plus.core.userCenter.vo.User;

public class SellerDaoTest {
  private static SellerDao sellerDao;

  @BeforeClass
  public static void setup() {
    ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:IOC.xml");
    sellerDao = (SellerDao) ac.getBean("sellerDao");

    assertNotNull(sellerDao);
  }
  
 @Test
 public void testGetAliItem() {
   try {
     List<AliItem> list = sellerDao.getAliItem(44805, "");
     assertNotNull(list);
   } catch (Exception e) {
     e.printStackTrace();
   }
 }
 
 @Test
 public void testGetTaobaoItem() {
   try {
     List<TaobaoItem> list = sellerDao.getTaobaoItem(718, "");
     assertNotNull(list);
   } catch (Exception e) {
     e.printStackTrace();
   }
 }
 
 @Test
 public void testGetDownloadSupplier() {
   try {
     List<LogDownload> list = sellerDao.getDownloadSupplier(57);
     assertNotNull(list);
   } catch (Exception e) {
     e.printStackTrace();
   }
 }
}
