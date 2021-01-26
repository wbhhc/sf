package com.kingtang.area.sf.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

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
//@ImportResource(locations={"classpath:application-bean.xml"})
@ComponentScan(basePackages = {
//        "com.kingtang.area.sf.config",
        "com.kingtang.area.sf.web.*"
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}