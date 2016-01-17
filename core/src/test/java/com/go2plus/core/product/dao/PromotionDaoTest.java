package com.go2plus.core.product.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.go2plus.core.promotion.dao.PromotionDao;
import com.go2plus.core.promotion.vo.Promotion;

public class PromotionDaoTest {

  private static PromotionDao promotionDao;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:IOC.xml");
    promotionDao = (PromotionDao) ac.getBean("promotionDao");

    assertNotNull(promotionDao);
  }

  @Test
  public void testGetSponsers() {
    try {
      Integer[] emptyPromotionId = {};
      List<Promotion> promotionList = promotionDao.getSponsers("f", emptyPromotionId);
      assertNotNull(promotionList);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
