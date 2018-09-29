package com.test;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.model.User;
import com.service.UserService;

/**   
 * @ClassName:  testweb   
 * @Description: TODO
 * @author: li_xj 
 * @date: 2018年9月16日 上午12:07:55   
 *     
 */
@RunWith(SpringJUnit4ClassRunner.class)       

@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" }) 

public class testweb {
	private static Logger logger = Logger.getLogger(testweb.class);
	
	@Resource
	private UserService userService;
	
	@Test(expected=java.lang.ArithmeticException.class)
	public void test1() {
		System.out.println("test1");
		User user = userService.getUserById(2);
		logger.info(JSON.toJSONString(user));
	}
}
