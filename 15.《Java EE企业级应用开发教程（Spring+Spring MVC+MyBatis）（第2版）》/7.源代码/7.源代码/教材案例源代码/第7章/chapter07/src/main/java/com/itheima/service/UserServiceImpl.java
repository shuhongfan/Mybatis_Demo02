package com.itheima.service;
import com.itheima.dao.UserDao;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
//使用@Service注解将UserServiceImpl类标识为Sring中的Bean
@Service("userService")
public class UserServiceImpl implements UserService {
    //使用@Resource注解注入UserDao
    @Resource(name="userDao")
    private UserDao userDao;
    public void save(){
        this.userDao.save();
        System.out.println("执行UserServiceImpl.save()");
    }
}