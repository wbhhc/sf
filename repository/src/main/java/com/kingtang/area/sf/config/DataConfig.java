package com.kingtang.area.sf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import javax.sql.DataSource;


@Configuration
@ComponentScan(basePackages = {
        "com.kingtang.area.sf.repository.impl",
        "com.kingtang.area.sf.business.service"
})
public class DataConfig implements TransactionManagementConfigurer {

    // 数据源
    @Autowired
    @Qualifier("sfDataSource")
    private DataSource sfDataSource;

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "sf.datasource")
    public DataSourceProperties sfDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "sf.datasource")
    public DataSource sfDataSource(){
        return sfDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    JdbcTemplate sfJdbcTemplate(@Qualifier("sfDataSource") DataSource sfDataSource) {
        return new JdbcTemplate(sfDataSource);
    }


    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(sfDataSource);
    }
}
