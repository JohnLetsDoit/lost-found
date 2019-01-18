package com.funtl.lost.found.web.admin.dao;

import com.funtl.lost.found.domain.User;

public interface UserDao {
    /**根据邮箱和密码获取用户信息
     *@Author John【chinacode@yeah.net】
     *@Date
     */
    User getUser(String email,String password);
}
