package com.go2plus.core.user.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.go2plus.common.json.Json;
import com.go2plus.core.userCenter.dao.UserDao;
import com.go2plus.core.userCenter.vo.User;

public class UserDaoTest {
  private static UserDao ud;

  @BeforeClass
  public static void setup() {
    ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:IOC.xml");
    ud = (UserDao) ac.getBean("userDao");

    assertNotNull(ud);
  }

  /**
   * 一对一关系测试
   */

  @Test
  public void testFindFullUserInfo() {
    try {
      User user = ud.findFullUserInfo(197);
      String jString = Json.toJson(user);
      System.out.println("用户姓名是：" + jString);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * test updateUser()
   */
  // @Test
  // public void testUpdateUser() {
  // try {
  // User u1 = ud.findUserById(40);
  // u1.setMobile("12345678910");
  // u1.setType(1);
  // u1.setUsername("csdsadsadadadsadasdsadadasdd");
  // u1.setState(1);
  // ud.updateUser(u1);
  // User u2 = ud.findUserById(40);
  // assertEquals("12345678910", u2.getMobile());
  // assertEquals((Integer) (1), (Integer) (u2.getType()));
  // assertEquals("csdsadsadadadsadasdsadadasdd", u2.getUsername());
  // assertEquals((Integer) (1), (Integer) u2.getState());
  //
  // } catch (Exception e) {
  // e.printStackTrace();
  // }

}
