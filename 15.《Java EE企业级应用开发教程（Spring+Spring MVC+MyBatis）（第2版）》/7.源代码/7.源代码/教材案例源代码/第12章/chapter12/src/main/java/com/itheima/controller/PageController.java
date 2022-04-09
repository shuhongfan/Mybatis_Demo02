package com.itheima.controller;
import com.itheima.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PageController {
    @RequestMapping("/register")
    public void showPageByVoid() {
        System.out.println("showPageByVoid running");
    }
    @RequestMapping("/showPageByString")
    public String showPageByString(){
        System.out.println("showPageByString running");
        return "register";
    }
    @RequestMapping("/showPageByForward")
    public String showPageByForward(){
        System.out.println("showPageByForward running");
        return "forward:orders.jsp";
    }
    @RequestMapping("/showPageByRedirect")
    public String showPageByRedirect(){
        System.out.println("showPageByRedirect running");
        return "redirect:http://www.itheima.com";
    }

    @RequestMapping("/showPageByRequest")
    public String showPageByRequest(HttpServletRequest request){
        System.out.println("showPageByRequest running");
        request.setAttribute("username","request");
        return "register";
    }
    @RequestMapping("/showPageByModel")
    public String showPageByModel(Model model){
        System.out.println("showPageByModel running");
        model.addAttribute("username","model");
        User user = new User();
        user.setPassword("password");
        model.addAttribute("user",user);
        return "register";
    }
    @RequestMapping("/showModelAndView")
    public ModelAndView showModelAndView(){
        //创建ModelAndView实例
        ModelAndView modelAndView = new ModelAndView();
        //向ModelAndView实例中添加名称为username的数据
        modelAndView.addObject("username","heima");
        User user = new User();
        user.setPassword("password");
        //向ModelAndView实例中添加名称为user的数据
        modelAndView.addObject("user",user);
        //向ModelAndView实例中设置视图的名称
        modelAndView.setViewName("register");
        return modelAndView;
    }


}

