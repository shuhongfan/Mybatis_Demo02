package com.itheima.controller;

import com.itheima.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class UserController {
    @RequestMapping("/getUserId")
    public void getUserId(HttpServletRequest request) {
        String userid = request.getParameter("userid");
        System.out.println("userid=" + userid);
    }

    @RequestMapping("/getUserNameAndId")
    public void getUserNameAndId(String username, Integer id) {
        System.out.println("username=" + username + ",id=" + id);
    }

    @RequestMapping("/user/{name}")
    public void getPathVariable(@PathVariable(value = "name")
                                        String username) {
        System.out.println("username=" + username);
    }

    /**
     * 接收表单用户信息
     */
    @RequestMapping("/registerUser")
    public void registerUser(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        System.out.println("username=" + username + ",password=" + password);
    }
    /**
     * 使用自定义类型数据绑定日期数据
     */
//    @RequestMapping("/getBirthday")
//    public void getBirthday(Date birthday) {
//        System.out.println("birthday="+birthday);
//    }

    /**
     * 使用@DateTimeFormat注解绑定日期数据
     */
    @RequestMapping("/getBirthday")
    public void getBirthday(@DateTimeFormat(
            pattern = "yyyy-MM-dd") Date birthday) {
        System.out.println("birthday=" + birthday);
    }

//    @RequestMapping("/findOrderWithUser")
//    public void findOrderWithUser(User user) {
//        String username = user.getUsername();
//        String orderId = user.getOrder().getOrderId();
//        System.out.println("username=" + username + ",orderId=" + orderId);
//    }

}

