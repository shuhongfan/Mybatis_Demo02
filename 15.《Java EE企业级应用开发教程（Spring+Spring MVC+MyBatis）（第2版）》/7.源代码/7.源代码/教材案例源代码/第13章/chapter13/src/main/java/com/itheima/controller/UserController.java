package com.itheima.controller;

import com.itheima.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    //跳转到系统首页
    @RequestMapping("/main")
    public String toMainPage() {
        return "main";
    }

    //跳转到登录页面
    @RequestMapping("/tologin")
    public String toLoginPage() {
        return "login";
    }

    //跳转到订单信息页面
    @RequestMapping("/orderinfo")
    public String orderinfo() {
        return "orderinfo";
    }

    /**
     * 用户登录
     */
    @RequestMapping("/login")
    public String login(User user, Model model, HttpSession session) {
        // 获取用户名和密码
        String username = user.getUsername();
        String password = user.getPassword();
        // 此处模拟从数据库中获取用户名和密码后进行判断
        if (username != null && username.equals("heima")
                && password != null && password.equals("123456")) {
            // 将用户对象添加到Session
            session.setAttribute("USER_SESSION", user);
            //用户登录成功，转发到系统首页
            return "main";
        }
        //如果用户名和密码不匹配，转发到登录页面，并进行提醒
        model.addAttribute("msg", "用户名或密码错误，请重新登录！");
        return "login";
    }

    /**
     * 用户退出
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // 清除Session
        session.invalidate();
        // 退出登录后重定向到登录页面
        return "redirect:tologin";
    }
}

