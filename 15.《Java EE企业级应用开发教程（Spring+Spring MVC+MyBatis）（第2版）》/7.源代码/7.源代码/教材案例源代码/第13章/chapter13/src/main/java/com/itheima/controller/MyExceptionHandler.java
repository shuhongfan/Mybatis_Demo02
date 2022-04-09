package com.itheima.controller;

import com.itheima.exception.MyException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

@Component
public class MyExceptionHandler implements HandlerExceptionResolver {
    /**
     * @param request  当前的 HTTP request
     * @param response 当前的 HTTP response
     * @param handler  正在执行的Handler
     * @param ex       handler执行时抛出的exception
     * @return 返回一个ModelAndView
     */
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {
        // 定义异常信息
        String msg;
        //如果是自定义异常，将异常信息直接返回
        if (ex instanceof MyException) {
            msg = ex.getMessage();
        } else {
            // 如果是系统的异常，从堆栈中获取异常信息
            Writer out = new StringWriter();
            PrintWriter s = new PrintWriter(out);
            ex.printStackTrace(s);
            //系统真实异常信息，可以以邮件,短信等方式发给相关开发人员
            String sysMsg = out.toString();
            //向客户隐藏真实的异常信息，仅发送友好提示信息
            msg = "网络异常！";
        }
        // 返回错误页面，给用户友好页面显示错误信息
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", msg);
        modelAndView.setViewName("error.jsp");
        return modelAndView;
    }
}

