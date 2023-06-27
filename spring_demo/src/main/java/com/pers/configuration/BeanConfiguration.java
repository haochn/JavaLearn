package com.pers.configuration;

import com.pers.pojo.DataConfig;
import com.pers.pojo.GlobalConfig;
import jdk.nashorn.internal.objects.Global;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public DataConfig dataConfig() {
        System.out.println("BeanConfiguration.dataConfig");
        DataConfig dataConfig = new DataConfig();
        dataConfig.setUrl("localhost:3306/dbname");
        dataConfig.setDriverName("Driver");
        dataConfig.setUserName("root");
        dataConfig.setPassword("root");
        System.out.println("BeanConfiguration:"+dataConfig);
        return dataConfig;
    }
    @Bean
    public DataConfig config() {
        System.out.println("BeanConfiguration.dataConfig");
        DataConfig dataConfig = new DataConfig();
        dataConfig.setUrl("localhost:3306/dbname");
        dataConfig.setDriverName("Driver");
        dataConfig.setUserName("root");
        dataConfig.setPassword("root");
        System.out.println("BeanConfiguration:"+dataConfig);
        return dataConfig;
    }

    @Bean
    public GlobalConfig globalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();
        return globalConfig;
    }
}
