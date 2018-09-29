package com.service.impl;
import java.util.List;

import javax.annotation.Resource;  
  
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.model.User;
import com.service.UserService;
  
@Service("userService")  
public class UserServiceImpl implements UserService {  
    @Resource  
    private UserDao userDao;  
    
    public User getUserById(int id) {  
        // TODO Auto-generated method stub  
        return this.userDao.selectByPrimaryKey(id);  
    }

	@Override
	public boolean regist(String username, String password) {
		System.out.println("==========");
		System.out.println("userServiceImpl, regist: " + username + password);
		System.out.println("输入的账号:" + username + "输入的密码:" + password);
		if (username==""||password=="") {
			return false;
		}else {
			userDao.addUser(username, password);
			return true;
		}
	}

	@Override
	public boolean login(String username, String password) {
		System.out.println("==========");
		System.out.println("userServiceImpl, login: " + username + password);
		System.out.println("输入的账号:" + username + "输入的密码:" + password);
		User user = userDao.findUserByNameAndPwd(username, password);
		if (user != null) {
          if (user.getUser_name().equals(username) && user.getUser_password().equals(password)) {
        	  return true;
          }
      }
      return false;
	}

	@Override
	public List<User> selectAll() {
		return this.userDao.selectAllUser();
	}


}  
