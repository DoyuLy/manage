package com.go2plus.core.user.dao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.go2plus.core.common.dao.MessageDao;
import com.go2plus.core.common.vo.Message;

public class MessageDaoTest {

  private static MessageDao messageDao;

  @BeforeClass
  public static void setup() {
    ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:IOC.xml");
    messageDao = (MessageDao) ac.getBean("messageDao");

    assertNotNull(messageDao);
  }

  @Test
  public final void testInsertUserMessage() {
    try {
      // Message message = new Message();
      // message.setContent("aaa");
      //
      // message.setUserId(888888);
      // messageDao.insertUserMessage(message);
      messageDao.queryLastMessage(888888);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
