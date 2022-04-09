package com.itheima.demo03;
import org.springframework.context.ApplicationContext;
import
        org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestXml{
    public static void main(String[] args){
        ApplicationContext context=new
                ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao=context.getBean("userDao",UserDao.class);
        userDao.delete();
        System.out.println();
        userDao.insert();
        System.out.println();
        userDao.select();
        System.out.println();
        userDao.update();
    }
}