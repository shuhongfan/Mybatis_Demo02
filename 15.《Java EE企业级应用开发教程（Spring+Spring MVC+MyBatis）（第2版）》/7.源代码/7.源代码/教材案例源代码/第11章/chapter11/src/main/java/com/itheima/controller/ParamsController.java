package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ParamsController {
    @RequestMapping(value = "/params", params = "id=1")
    public void findById(String id) {
        System.out.println("id=" + id);
    }
}
