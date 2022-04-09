package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {
    //设定当前方法的访问映射地址列表
    @RequestMapping(value = {"/addUser", "/deleteUser"})
    public void checkAuth() {
        System.out.println("增删操作校验");
    }
}
