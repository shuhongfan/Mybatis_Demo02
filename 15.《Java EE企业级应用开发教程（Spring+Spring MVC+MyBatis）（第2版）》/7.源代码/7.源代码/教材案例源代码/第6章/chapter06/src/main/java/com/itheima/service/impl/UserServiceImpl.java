package com.itheima.service.impl;
import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
public class UserServiceImpl implements UserService {
    UserDao userDao;
    public void setUserDao(UserDao userDao){
        this.userDao=userDao;
    }
    @Override
    public boolean login(String name, String password) {
        return userDao.login(name,password);
    }
}