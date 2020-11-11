package com.kingtang.area.sf.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 为了在主程序配置datasource，禁用自动配置datasource，
 * web/config/MyBatisConfig.java手动配置datasource
 *
 * 不扫描repository.config
 */
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
})
@EnableFeignClients
@ComponentScan(basePackages = {
        "com.kingtang.area.sf.repository.impl",
        "com.kingtang.area.sf.business.service",
        "com.kingtang.area.sf.web.*"
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}