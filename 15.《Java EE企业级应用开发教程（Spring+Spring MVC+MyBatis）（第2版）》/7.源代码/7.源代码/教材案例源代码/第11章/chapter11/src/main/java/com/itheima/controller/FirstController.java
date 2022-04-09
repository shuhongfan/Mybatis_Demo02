package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/springMVC")
public class FirstController {
    @RequestMapping(value="/firstController")
    public void sayHello() {
        System.out.println("hello Spring MVC");
    }
}