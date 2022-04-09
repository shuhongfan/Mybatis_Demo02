package com.itheima.controller;

import com.itheima.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

@Controller
public class ExceptionController {
    //抛出空指针异常
    @RequestMapping("showNullPointer")
    public void showNullPointer() {
        ArrayList<Object> list = new ArrayList<>();
        System.out.println(list.get(2));
    }

    //抛出IO异常
    @RequestMapping("showIOException")
    public void showIOException() throws IOException {
        FileInputStream in = new FileInputStream("JavaWeb.xml");
    }

    //抛出算术异常
    @RequestMapping("showArithmetic")
    public void showArithmetic() {
        int c = 1 / 0;
    }

    @RequestMapping("addData")
    public void addData() throws MyException {
        throw new MyException("新增数据异常！");
    }

}

