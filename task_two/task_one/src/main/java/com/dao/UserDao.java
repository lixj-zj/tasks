package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.User;


/**   
 * @ClassName:  UserDao   
 * @Description: TODO
 * @author: li_xj 
 * @date: 2018年9月16日 上午12:07:06   
 *     
 */
public interface UserDao {

    User selectByPrimaryKey(Integer id);
    
    public void addUser(@Param("user_name")String username,@Param("user_password") String password);
    
    public User findUserByNameAndPwd(@Param("user_name")String username,@Param("user_password") String password);
	
    public List<User> selectAllUser();
    
}