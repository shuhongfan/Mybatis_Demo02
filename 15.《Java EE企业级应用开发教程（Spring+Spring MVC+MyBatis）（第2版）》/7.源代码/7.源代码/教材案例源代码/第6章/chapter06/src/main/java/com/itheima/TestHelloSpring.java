package com.itheima;
import org.springframework.context.ApplicationContext;
import
        org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestHelloSpring {
    public static void main(String[] args){
        //初始化spring容器，加载applicationContext.xml配置
        ApplicationContext applicationContext=new
                ClassPathXmlApplicationContext("applicationContext.xml");
        //通过容器获取配置中helloSpring的实例
        HelloSpring helloSpring=
                (HelloSpring)applicationContext.getBean("helloSpring");
        helloSpring.show();//调用方法
    }
}