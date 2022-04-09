package com.itheima.demo01;
public class JDKTest {
    public static void main(String[] args) {
        // 创建代理对象
        MyProxy jdkProxy = new MyProxy();
        // 创建目标对象
        UserDao userDao = new UserDaoImpl();
        // 从代理对象中获取增强后的目标对象
        UserDao userDao1 = (UserDao) jdkProxy.createProxy(userDao);
        // 执行方法
        userDao1.addUser();
        userDao1.deleteUser();
    }
}