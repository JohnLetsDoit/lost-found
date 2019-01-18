package com.funtl.lost.found.web.admin.web.interceptor;

import com.funtl.lost.found.commons.constant.ConstantUtils;
import com.funtl.lost.found.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    /**登录拦截
     *@Author John【chinacode@yeah.net】
     *@Date
     */
        public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
            User user = (User) httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_USER);

            // 判断用户是否登录
            if (user == null) {
                // 用户未登录，重定向到登录页
                httpServletResponse.sendRedirect("/login");
                return false;
            }else {
            // 放行
            return true;
        }
        }

        public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
            // 如果请求来自登录页
            if (modelAndView.getViewName().endsWith("login")) {
                // 则直接重定向到首页不再显示登录页
                httpServletResponse.sendRedirect("/main");

            }
        }

        public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

        }
    }