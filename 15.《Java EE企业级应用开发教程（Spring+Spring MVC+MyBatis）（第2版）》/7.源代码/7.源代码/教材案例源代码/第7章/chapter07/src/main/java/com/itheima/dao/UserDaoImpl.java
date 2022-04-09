package com.itheima.dao;

import com.itheima.entity.User;
import org.springframework.context.ApplicationContext;
import
        org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
//使用@Repository注解将UserDaoImpl类标识为Spring中的Bean
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    public void save(){
        ApplicationContext applicationContext=new
                ClassPathXmlApplicationContext("applicationContext.xml");
        User user=(User) applicationContext.getBean("user");
        System.out.println(user);
        System.out.println("执行UserDaoImpl.save()");
    }
}