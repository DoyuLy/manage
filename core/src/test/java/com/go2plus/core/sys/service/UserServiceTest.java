package com.go2plus.core.sys.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.go2plus.core.sys.vo.Menu;
import com.go2plus.core.sys.vo.User;

public class UserServiceTest {
	private static UserService userService;
	 
	@BeforeClass
	  public static void setUpBeforeClass() throws Exception {
	    ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:IOC.xml");
	    userService = (UserService) ac.getBean("userServiceImpl");
	    assertNotNull(userService);
	    
	  }
	@Test
	public void test() {
		//fail("Not yet implemented");
		List<User> list = userService.findAll(); 
		String json = JSON.toJSONString(list);
		System.out.println(json);
	}

}
