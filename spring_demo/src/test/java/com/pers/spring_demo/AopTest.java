package com.pers.spring_demo;

import com.pers.aop.Cal;
import com.pers.aop.CalImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTest {
    @Test
    public void aoptest1(){
        ApplicationContext context = new AnnotationConfigApplicationContext("com.pers.aop");
        Cal bean = context.getBean(Cal.class);
        System.out.println(bean.add(1, 2));
        System.out.println(bean.sub(3,1));

//        Cal bean2 = (Cal) context.getBean("impl2");
//        System.out.println(bean2.add(1, 2));
//        System.out.println(bean2.sub(3,1));

//        Cal bean3 = context.getBean(CalImpl.class);
//        System.out.println(bean3.add(1, 2));
//        System.out.println(bean3.sub(3,1));
    }
}
