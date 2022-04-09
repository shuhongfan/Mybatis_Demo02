package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("hello")
    public String hello() {
        System.out.println("HelloController...Hello");
        return "success.jsp";
    }

    @RequestMapping("exp")
    public String exp() {
        System.out.println(1 / 0);
        return "success.jsp";
    }
}

