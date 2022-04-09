package com.itheima;
import org.springframework.context.ApplicationContext;
import
        org.springframework.context.support.ClassPathXmlApplicationContext;
public class Bean3Test {
    public static void main(String[] args) {
        // ApplicationContext在加载配置文件时，对Bean进行实例化
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationBean3.xml");
        System.out.println(applicationContext.getBean("bean3"));
    }
}