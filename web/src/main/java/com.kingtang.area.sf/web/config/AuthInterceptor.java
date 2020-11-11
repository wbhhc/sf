package com.kingtang.area.sf.web.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录权限拦截器
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {
    private String usernameParameter = "username";
    private String defaultFailureUrl;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        //拦截验证登录状态
        Object usernameSession = request.getSession().getAttribute(usernameParameter);
        if(usernameSession!=null){
            return true;
        }else{
            if(!StringUtils.isEmpty(defaultFailureUrl))
                response.sendRedirect(defaultFailureUrl);
            return false;
        }
    }

    public void setDefaultFailureUrl(String defaultFailureUrl) {
        this.defaultFailureUrl = defaultFailureUrl;
    }

}
