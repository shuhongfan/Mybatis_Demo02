package com.itheima.controller;

import com.itheima.dao.StudentDao;
import com.itheima.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class StudentController {
    public static void main(String[] args) {
        System.out.println("欢迎来到学生管理系统");
        System.out.println("请输入用户名：");
        Scanner sca = new Scanner(System.in);
        String name = sca.nextLine();
        // 加载配置文件
        ApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("applicationContext-student.xml");
        // 获取AccountDao实例
        StudentDao studentDao =
                (StudentDao) applicationContext.getBean("studentDao");
        // 执行findAllAccount()方法,获取Account对象的集合
        List<Student> student = studentDao.findAllStudent();
        // 循环输出集合中的对象
        for (Student stu : student) {
            if (name.equals(stu.getUsername())) {
                System.out.println("请输入" + stu.getUsername() + "的密码：");
                String mima = sca.nextLine();
                if (mima.equals(stu.getPassword())) {
                    System.out.println("用户登录成功！");
                    System.out.println(stu.getUsername() + "是" + stu.getCourse() + "班的");
                    return;
                }
            } else {
                System.out.println("账号密码错误！");
                return;
            }
        }
    }
}

