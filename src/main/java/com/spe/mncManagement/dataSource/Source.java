package com.spe.mncManagement.dataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class Source {

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        String url = System.getenv("DATABASE_HOST");
        if(url !=null){
            dataSourceBuilder.url("jdbc:mysql://mncManagement:3306/SPE_mncManagement?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true&autoReconnect=true&failOverReadOnly=false&maxReconnects=10");
            dataSourceBuilder.username("root");
            dataSourceBuilder.password("spe");
        }else{
            dataSourceBuilder.url("jdbc:mysql://localhost:3306/SPE_mncManagement?createDatabaseIfNotExist=true");
            dataSourceBuilder.username("spe");
            dataSourceBuilder.password("spe");
        }

        return dataSourceBuilder.build();
    }
}
