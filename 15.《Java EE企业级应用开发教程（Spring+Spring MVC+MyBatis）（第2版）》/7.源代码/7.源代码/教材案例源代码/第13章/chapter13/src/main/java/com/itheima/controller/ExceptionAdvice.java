package com.itheima.controller;

import com.itheima.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@ControllerAdvice
public class ExceptionAdvice {
    //处理MyException类型的异常
    @ExceptionHandler(MyException.class)
    public ModelAndView doMyException(MyException ex) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", ex.getMessage());
        modelAndView.setViewName("error.jsp");
        return modelAndView;
    }

    //处理Exception类型的异常
    @ExceptionHandler(Exception.class)
    public ModelAndView doOtherException(Exception ex) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "网络异常！");
        modelAndView.setViewName("error.jsp");
        return modelAndView;
    }
}

