package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/method")
public class MethodController {
    //处理请求方式为 GET 的请求
    @RequestMapping(method = RequestMethod.GET)
    public void get() {
        System.out.println("RequestMethod.GET");
    }

    //处理请求方式为 DELETE 的请求
    @RequestMapping(method = RequestMethod.DELETE)
    public void delete() {
        System.out.println("RequestMethod.DELETE");
    }

    //处理请求方式为 POST 的请求
    @RequestMapping(method = RequestMethod.POST)
    public void post() {
        System.out.println("RequestMethod.POST");
    }

    //处理请求方式为 PUT 的请求
    @RequestMapping(method = RequestMethod.PUT)
    public void put() {
        System.out.println("RequestMethod.PUT");
    }

    @RequestMapping(value = "/method",
            method = {RequestMethod.GET,RequestMethod.POST})
    public void getAndPost() {
        System.out.println("RequestMethod.GET+RequestMethod.POST");
    }
}
