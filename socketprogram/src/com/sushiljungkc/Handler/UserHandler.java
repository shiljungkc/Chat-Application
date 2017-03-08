/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sushiljungkc.Handler;

import com.sushiljungkc.entity.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class UserHandler {
    List<User> userList=new ArrayList();

    public UserHandler() {
        
        userList.add(new User("sushil","sushil"));
        userList.add(new User("rajan","rajan"));
        userList.add(new User("sabina","sabina"));
       
    }
    
    public List<User> getAllUsers()
    {
        return userList;
    }
    public User getByUserName(String userName)
    {
        for(User u:userList)
        {
            if(u.getUserName().equals(userName))
            {
                return u;
            }
        }
        return null;
    }
    
    
}
