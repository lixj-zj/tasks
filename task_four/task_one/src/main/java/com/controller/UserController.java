package com.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.model.User;
import com.service.UserService;

/**
 * 
 * @ClassName:  userController   
 * @Description: TODO
 * @author: li_xj 
 * @date: 2018年9月15日 下午4:20:53   
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	//测试
	@RequestMapping(value="/showUser/{id}", method=RequestMethod.GET)
	public String showUser(@PathVariable int id, HttpServletRequest request) {
		System.out.println(id);
		User user = userService.getUserById(id);
		System.out.println(user);
		request.setAttribute("user", user);
		return "showUser";
	}
	
	//正常访问index页面
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    
  //正常访问system_index页面
    @RequestMapping("/system_index")
    public String system_index(){
        return "system_index";
    }
	
    //验证regist
	@RequestMapping(value="/checkRegist", method=RequestMethod.POST, produces="text/html;charset=UTF-8;")
	@ResponseBody //只返回数据，不返回页面
	public String checkRegist(HttpServletRequest request, @RequestBody String user) {
		System.out.println("==========");
		String[] strs=user.split("\"");	
		String username = strs[3];
		String password = strs[7];
		System.out.println("用户注册：" + username + password);
		
		boolean registType = userService.regist(username, password);
		JSONObject jsonObject = new JSONObject();
		if (registType) {
			jsonObject.put("message", "注册成功！");
            return jsonObject.toJSONString();
		}else{ 
			jsonObject.put("message", "注册失败！");
            return jsonObject.toJSONString();
        }
	}
	
    //验证login
	@RequestMapping(value="/checkLogin", method=RequestMethod.POST,  produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String checkLogin(HttpServletRequest request, @RequestBody String user) {
		System.out.println("==========");
		String[] strs=user.split("\"");	
		String username = strs[3];
		String password = strs[7];
		System.out.println("用户登录：" + username + password);
		
		boolean loginType = userService.login(username, password);
		System.out.println(loginType);
		JSONObject jsonObject = new JSONObject();
        if(loginType){
        	jsonObject.put("message", "true");
            return jsonObject.toJSONString();
        }else{ 
        	jsonObject.put("message", "fail");
            return jsonObject.toJSONString();
        }
	}
	
	// 查询所有用户
	@RequestMapping(value="/selectAllUser", method=RequestMethod.POST,  produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String selectAllUser(HttpServletRequest request) {
		System.out.println("=====选择所有用户======");
		List<User> userList = userService.selectAll();
		JSONArray jsonArray = new JSONArray();
		for(User user:userList) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", user.getId());
			jsonObject.put("user_name", user.getUser_name());
			jsonObject.put("user_password", user.getUser_password());
			
			jsonArray.add(jsonObject);
		}
		System.out.println(jsonArray);
		return jsonArray.toJSONString();
	}
}

