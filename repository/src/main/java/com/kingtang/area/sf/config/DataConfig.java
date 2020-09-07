package com.kingtang.area.sf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import javax.sql.DataSource;


@Configuration
public class DataConfig implements TransactionManagementConfigurer {

    // 数据源
    @Autowired
    private DataSource dataSource;

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "jdbc.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "jdbc.datasource")
    public DataSource dataSource(){
        return dataSourceProperties().initializeDataSourceBuilder().build();
    }


    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
