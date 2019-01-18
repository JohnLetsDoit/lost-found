package com.funtl.lost.found.web.admin.dao.impl;

import com.funtl.lost.found.domain.User;
import com.funtl.lost.found.web.admin.dao.UserDao;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository
public class UserDaoImpl implements UserDao {
   private final org.slf4j.Logger logger=LoggerFactory.getLogger(UserDaoImpl.class);

   public User getUser(String email,String password) {
       logger.debug("调用getUser,email:{} password:{}", email, password);

       User user = null;

       if ("admin@funtl.com".equals(email)) {
           if ("admin".equals(password)) {
               user = new User();
               user.setEmail("admin@funtl.com");
               user.setUsername("John");
               logger.info("成功获取\"{}\"的信息", user.getUsername());
           } else {
               logger.warn("获取\"{}\"的用户信息失败");
           }
       }
       return user;
   }
}