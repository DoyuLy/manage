package com.go2plus.core.logDownload.dao;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.go2plus.core.publish.dao.LogDownloadDao;
import com.go2plus.core.publish.vo.LogDownload;


public class LogDownloadDaoTest {

  private static LogDownloadDao logDownloadDao;

  @BeforeClass
  public static void setup() {
    ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:IOC.xml");
    logDownloadDao = (LogDownloadDao) ac.getBean("logDownloadDao");

    assertNotNull(logDownloadDao);
  }   
  
  @Test
  public void testGetLogDownloads() {
    try {
      List<LogDownload> logDownloadList = logDownloadDao.getLogDownloads(49786, "log_download");
      assertNotNull(logDownloadList);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testDelMultiDownload() {
    try {
      int[] ids = {6367330, 6367333};
      logDownloadDao.delMultiDownload(ids, "log_download");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}

