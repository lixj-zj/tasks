package com.service;  

import java.util.List;

import com.model.User;
  
public interface UserService {  
    public User getUserById(int id);
    
    public boolean regist(String username, String password);
    
    public boolean login(String username, String password);
    
    public List<User> selectAll();
}  