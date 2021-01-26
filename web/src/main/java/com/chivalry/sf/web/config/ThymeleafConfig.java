package com.chivalry.sf.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Thymeleaf模板全局配置
 */
@Configuration
public class ThymeleafConfig {

    @Resource
    private Environment env;

    @Resource
    private void configureThymeleafStaticVars(ThymeleafViewResolver viewResolver) {
        if(viewResolver != null) {
            Map<String, Object> vars = new HashMap<>();
            vars.put("title", env.getProperty("params.title"));
            vars.put("logoImg",env.getProperty("params.basic.logo-img"));
            vars.put("loginBanner",env.getProperty("params.basic.login-banner"));
            vars.put("homePath",env.getProperty("params.homePath"));
            vars.put("hsbpDisplayRegister",env.getProperty("params.hsbp.displayRegister"));
            vars.put("hsbpRegisterPath",env.getProperty("params.hsbp.registerPath"));
            vars.put("hsbplogo",env.getProperty("params.hsbp.logo"));
            vars.put("hsbploginPic",env.getProperty("params.hsbp.login-pic"));
            vars.put("hsbploginCenter",env.getProperty("params.hsbp.login-center"));
            vars.put("hsbpslide1",env.getProperty("params.hsbp.slide1"));
            vars.put("hsbpslide2",env.getProperty("params.hsbp.slide2"));
            vars.put("hsbpslide3",env.getProperty("params.hsbp.slide3"));
            vars.put("complexPwd",env.getProperty("params.complexPwd"));
            viewResolver.setStaticVariables(vars);
        }
    }

}
