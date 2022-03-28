package com.le_chatelet.le_chatelet_back.databaseaccess;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

    @Bean(name = "mySqlDataSource")
    @Primary
    public DataSource mySqlDataSource()
    {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://localhost/ip_user");
        dataSourceBuilder.username("lechatelet");
        dataSourceBuilder.password("Javaspring77/");
        return dataSourceBuilder.build();
    }
}
