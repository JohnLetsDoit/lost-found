package com.funtl.lost.found.web.admin.service;

import com.funtl.lost.found.domain.User;


public interface UserService {
    /**登入
     *@Author John【chinacode@yeah.net】
     *@Date
     */
    User login(String email, String password);
}
