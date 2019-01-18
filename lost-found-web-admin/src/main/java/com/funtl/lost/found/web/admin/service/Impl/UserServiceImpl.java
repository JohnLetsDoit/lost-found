package com.funtl.lost.found.web.admin.service.Impl;

import com.funtl.lost.found.domain.User;
import com.funtl.lost.found.web.admin.dao.UserDao;
import com.funtl.lost.found.web.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
   @Autowired
    private UserDao userDao;

    public User login(String email,String password){
        return userDao.getUser(email,password);
    }
}
