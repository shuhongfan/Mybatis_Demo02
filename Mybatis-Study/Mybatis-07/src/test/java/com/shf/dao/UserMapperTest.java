package com.shf.dao;

import com.shf.pojo.User;
import com.shf.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserMapperTest {
    //    二级缓存顺序
//    1. 先看二级缓存中有没有
//    2.再看一级缓存中有没有
//    3.查询数据库
    @Test
    public void test() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        SqlSession sqlSession2 = MyBatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);
        sqlSession.close();

//        增删改操作，会改变原来的数据，必定会刷新缓存
//        mapper.updateUser(new User(2, "aaa", "bbb"));

//        手动清理缓存  一级缓存默认是开启的，只在一次sqlsession中有效
//        sqlSession.clearCache();

        System.out.println("====================");
//        一级缓存 sqlsession
        user = mapper2.queryUserById(1);
        System.out.println(user);


        sqlSession2.close();
    }
}
