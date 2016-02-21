package com.go2plus.core.sys.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.go2plus.core.sys.vo.Menu;

public class MenuDaoTest {
	private static MenuDao menuDao;
	@BeforeClass
	  public static void setup() {
	    ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:IOC.xml");
	    menuDao = (MenuDao) ac.getBean("menuDao");

	    assertNotNull(menuDao);
	  }
	@Test
	public void test() {
		List<Menu> list = menuDao.findAll();
		String json = JSON.toJSONString(list);
		System.out.println(json);
	}

}
