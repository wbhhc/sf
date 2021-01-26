package com.chivalry.sf.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    UserPlatformLoginFilter userPlatformLoginFilter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/auth",
                        "/login",
                        "/excel/**",
                        "/js/**",
                        "/libs/**",
                        "/css/**",
                        "/fonts/**",
                        "/img/**",
                        "/error/**",
                        "/swagger-ui.html","/swagger-resources/**","/webjars/**","/api/**","/file/api/**","/webjars/springfox-swagger-ui/**","/v2/api-docs"
                        ,"/**"
                        );

    }

    public AuthInterceptor authInterceptor(){
        AuthInterceptor authInterceptor=new AuthInterceptor();
        authInterceptor.setDefaultFailureUrl("/login");//拦截器验证登录状态失败后默认跳转的url
        return authInterceptor;
    }

    @Bean
    public FilterRegistrationBean registFilter() {
        userPlatformLoginFilter.setDefaultFailureUrl("/login");//过滤器用户平台单点登录验证失败后默认跳转的url
        //注册用户平台单点登录过滤器
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(userPlatformLoginFilter);
        registration.addUrlPatterns("/auth");//用户平台单点登录过滤器url
        registration.setName("UP_LOGIN_FILTER");
        registration.setOrder(1);
        return registration;
    }
}
