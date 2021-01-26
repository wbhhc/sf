package com.chivalry.sf.config;

import com.chivalry.sf.core.SfJdbcTemplateFactory;
import com.chivalry.sf.core.SfScannerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import javax.sql.DataSource;


@Configuration
@Import(SfScannerConfig.class)
public class DataConfig implements TransactionManagementConfigurer {


    @Autowired
    @Qualifier("sfDataSource")
    private DataSource sfDataSource;

    // 数据源1
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


    //指定sf数据源
    @Bean
    SfJdbcTemplateFactory sfJdbcTemplateFactory(){
        return new SfJdbcTemplateFactory(new JdbcTemplate(sfDataSource));
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(sfDataSource);
    }
}
