package com.kingtang.area.sf.web.config;

import com.kingtang.area.sf.web.clinet.SsoClient;
import com.kingtang.area.userplatform.business.domain.SsoToken;
import com.kingtang.area.userplatform.business.domain.SysMenu;
import com.kingtang.area.userplatform.business.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@Component
public class UserPlatformLoginFilter implements Filter {

    Logger log= Logger.getLogger(UserPlatformLoginFilter.class.getName());

    private String usernameParameter = "username";
    private String idParameter = "accid";
    private String nameParameter = "accname";
    private String orgCodeParameter = "accorg";
    private String menusParameter ="accmenus";
    private String tokenParameter = "token";
    private String appKey="emergency-control";

    private boolean getOnly = true;
    private String defaultFailureUrl;

    @Autowired
    SsoClient ssoClient;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        if (this.getOnly && !request.getMethod().equals("GET")) {
            throw new ServletException("Authentication method not supported: " + request.getMethod());
        }else{
            String username = request.getParameter("user_id");
            String sessionCode = request.getParameter("session_code");
            String targetPage = request.getParameter("target_page");
            if(isAuthenticated(username,request)){//验证是否登录
                if(!StringUtils.isEmpty(targetPage))
                    response.sendRedirect(targetPage);
                return;
            }
            //未登录则需要做session_code校验
            String token = getToken(sessionCode);
            if(!StringUtils.isEmpty(token))
            {
                login(username,token,request);
                if(!StringUtils.isEmpty(targetPage))
                    response.sendRedirect(targetPage);
                return;
            }
        }
        response.sendRedirect(defaultFailureUrl);
    }

    @Override
    public void destroy() {

    }

    /**验证用户是否登录
     * @param username
     * @param request
     * @return
     */
    private boolean isAuthenticated(String username,HttpServletRequest request){
        Object usernameSession = request.getSession().getAttribute(usernameParameter);
        if(usernameSession!=null && username.equals(usernameSession.toString())){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 执行登录操作
     * @param username
     * @param token
     * @param request
     */
    private void login(String username,  String token,HttpServletRequest request) {
        request.getSession().setAttribute(usernameParameter, username);
        request.getSession().setAttribute(tokenParameter,token);
        //保存账号信息
        SysUser pubEmp = ssoClient.getUserInfo(username);
        if(pubEmp==null) throw new RuntimeException("账号不存在！");
        request.getSession().setAttribute(idParameter, pubEmp.getId());
        request.getSession().setAttribute(nameParameter, pubEmp.getName());


        //获取用户在本系统模块中所拥有的菜单，并暂存
        cacheUserMenus(username,request);
    }

    private void cacheUserMenus(String username,HttpServletRequest request){
        SysUser pubEmp = ssoClient.getUserAllMenus(username);
        request.getSession().setAttribute(menusParameter, pubEmp.getMenus());

        if(pubEmp!=null){
            for(SysMenu menu : pubEmp.getMenus()){
                log.info("菜单："+ menu.getTitle() + " " +menu.getUrl());
            }
        }
    }

    /**
     * 向sso换取token
     * @param sessionCode
     * @return
     */
    private String getToken(String sessionCode){
        log.info("请求授权服务...！");
        SsoToken ssoToken;
        try{
            ssoToken = ssoClient.getToken(sessionCode);
        }catch (Exception e){
            log.info(e.getMessage());
            throw new RuntimeException("请求授权服务失败："+e.getMessage());
        }
        if(ssoToken!=null && ssoToken.getToken()!=null)
            return ssoToken.getToken();
        else
            return null;
    }

    public void setDefaultFailureUrl(String defaultFailureUrl) {
        this.defaultFailureUrl = defaultFailureUrl;
    }
}
