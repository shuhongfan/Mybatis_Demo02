package com.itheima;
import com.itheima.service.UserService;
import org.springframework.context.ApplicationContext;
import
        org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestSpring {
    public static void main(String[] args){
        //加载applicationContext.xml配置
        ApplicationContext applicationContext=new
                ClassPathXmlApplicationContext("applicationContext.xml");
        //获取配置中的UserService实例
        UserService userService=(UserService)
                applicationContext.getBean("userService");
        boolean flag =userService.login("张三","123");
        if (flag){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
    }
}