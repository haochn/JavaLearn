package com.pers.spring_demo;


import com.pers.configuration.BeanConfiguration;
import com.pers.pojo.DataConfig;
import com.pers.pojo.GlobalConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDataConfig {
    @Test
    public void test() {
        // 不使用IoC，手动 new 对象
        DataConfig dataConfig = new DataConfig();
        dataConfig.setUrl("localhost:3306/dbname");
        dataConfig.setDriverName("Driver");
        dataConfig.setUserName("root");
        dataConfig.setPassword("root");
        System.out.println(dataConfig);
    }

    @Test
    public void test1() {
        // 基于注解 1.通过配置类BeanConfiguration
        // DataConfig 对象已经 在BeanConfiguration 被托管给 Spring
        // 成员变量的值以@@Value("")为准
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        // 方法名
        System.out.println(context.getBean("dataConfig"));

        ApplicationContext context1 = new AnnotationConfigApplicationContext("com.pers.configuration");
        // 类名
        System.out.println(context1.getBean(DataConfig.class));
    }

    @Test
    public void test2() {
        // 基于注解 2.扫包+注解（实体类@Component,成员变量@Value进行赋值）
        // DataConfig 对象已经 在BeanConfiguration 被托管给 Spring
        ApplicationContext context = new AnnotationConfigApplicationContext("com.pers.pojo");
        // 方法名
        System.out.println(context.getBean("dataConfig"));
        // 类名
        System.out.println(context.getBean(DataConfig.class));
    }

    @Test
    public void test3() {
        // 基于注解 2.扫包+注解（实体类@Component,成员变量@Value进行赋值）
        // DataConfig 对象已经 在BeanConfiguration 被托管给 Spring
        ApplicationContext context = new AnnotationConfigApplicationContext("com.pers.pojo");
        // 类名
        System.out.println(context.getBean(GlobalConfig.class));
    }

    @Test
    public void test4() {
        // 基于注解 2.扫包+注解（实体类@Component,成员变量@Value进行赋值）
        // DataConfig 对象已经 在BeanConfiguration 被托管给 Spring
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        // 类名
        System.out.println(context.getBean(GlobalConfig.class));
    }
}

