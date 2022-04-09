package com.itheima.controller;
import com.itheima.service.UserService;
import org.springframework.stereotype.Controller;
import javax.annotation.Resource;
//使用Controller注解将UserController类标识为Spring中的Bean
@Controller
public class UserController {
    //使用@Resource注解注入UserService
    @Resource(name="userService")
    private UserService userService;
    public void save(){
        this.userService.save();
        System.out.println("执行UserController.save()");
    }
}