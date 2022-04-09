package com.shf.dao;

import com.shf.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList2();

    //    分页
    List<User> getUserByLimit(Map<String, Integer> map);

    //    分页2
    List<User> getUserByRowBounds();

    @Select("select * from user")
    List<User> getUsers();

    //    方法有多个参数，所有的参数前面必须加上@Param
    @Select("select * from user where id=#{id}")
    User getUserById(@Param("id") int id);

    @Insert("insert into user(id,name,pwd) values (#{id},#{name},#{password})")
    int addUser(User user);


    @Update("update user set name=#{name},pwd=#{password} where id =#{id}")
    int updateUser(User user);

    @Delete("delete from user where id=#{uid}")
    int deleteUser(@Param("uid") int id);
}
