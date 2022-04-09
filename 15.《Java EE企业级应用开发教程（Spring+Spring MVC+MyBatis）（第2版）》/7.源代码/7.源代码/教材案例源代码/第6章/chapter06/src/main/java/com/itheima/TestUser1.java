package com.itheima;
import org.springframework.context.ApplicationContext;
import
        org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestUser1 {
    public static void main(String[] args)throws Exception{
        //加载applicationContext.xml配置
        ApplicationContext applicationContext=new
                ClassPathXmlApplicationContext("applicationContext-User.xml");
        //获取配置中的User1实例
        User1 user1=applicationContext.getBean("user1", User1.class);
        System.out.println(user1);
    }
}