package com.pers.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class GlobalConfig {
    @Value("8080")
    private String port;
    @Value("/")
    private String path;
    // @Autowired 通过 类型DataConfig.class 从IoC中取
    @Autowired
    // @Qualifier("config") 通过name = "config" 去IoC容器找对象,那么DataConfig类的注解应该是@Component("config")
    @Qualifier("config")
    private DataConfig dataConfig;
}
