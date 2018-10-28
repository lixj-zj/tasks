//package com.test;
//
//
//import java.util.concurrent.TimeUnit;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.BoundValueOperations;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.model.User;
//import com.service.UserService;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" }) 
//public class RedisClusterTest {
//
//	
//	private UserService userService;
//	//测试
//	@RequestMapping(value="/showUser/{id}", method=RequestMethod.GET)
//	public String showUser(@PathVariable int id, HttpServletRequest request) {
//		System.out.println(id);
//		User user = userService.getUserById(id);
//		System.out.println(user);
//		request.setAttribute("user", user);
//		return "showUser";
//	}
//
//	
//	@Resource(name="redisTemplate")
//	private RedisTemplate<String, Object> redisTemplate;
//	@Test
//	public void testSaveAndGet(){
//		User user = userService.getUserById(2);
//		ValueOperations<String, Object> valueOperation = redisTemplate.opsForValue();
//		valueOperation.set("user_cluster" + user.getId(), user);
//		
//		User result = (User) valueOperation.get("user_cluster" + user.getId());
//		System.out.println("name: " + result.getUser_name());
//		
//
//	}
//
//	@Test
//	public void testBoundOperations(){
//		BoundValueOperations<String, Object> boundValueOperations = redisTemplate.boundValueOps("BoundTest");
//		//设置值
//		boundValueOperations.set("test12345");
//		//设置过期时间
//		boundValueOperations.expire(100, TimeUnit.SECONDS);
//		//重命名Key
////		boundValueOperations.rename("BoundTest123");
//	
//		System.out.println("key: " + boundValueOperations.getKey());
//		System.out.println(boundValueOperations.get());
//		System.out.println("expire: " + boundValueOperations.getExpire());
//	}
//
//}
