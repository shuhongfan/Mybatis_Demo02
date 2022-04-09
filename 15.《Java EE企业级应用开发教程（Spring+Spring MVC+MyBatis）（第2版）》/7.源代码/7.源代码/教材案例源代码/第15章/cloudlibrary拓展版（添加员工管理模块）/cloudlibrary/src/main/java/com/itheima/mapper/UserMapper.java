package com.itheima.mapper;
import com.github.pagehelper.Page;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;

/**
 * 用户操作接口
 */
public interface UserMapper{
    @Select("select * from user where user_email=#{email} AND user_password=#{password} AND user_status!='1'")
    @Results(id = "userMap",value = {
            //id字段默认为false，表示不是主键
            //column表示数据库表字段，property表示实体类属性名。
            @Result(id = true,column = "user_id",property = "id"),
            @Result(column = "user_name",property = "name"),
            @Result(column = "user_password",property = "password"),
            @Result(column = "user_email",property = "email"),
            @Result(column = "user_hiredate",property = "hiredate"),
            @Result(column = "user_role",property = "role"),
            @Result(column = "user_status",property = "status"),
            @Result(column = "user_departuredate",property = "departuredate")
    })
    //用户登录
    User login(User user);
    //新增用户
    void addUser(User user);
    //编辑用户信息
    void editUser(User user);

    @Select({"<script>" +
            "SELECT * FROM user " +
            "where 1=1 " +
            "<if test=\"id != null\"> AND  user_id  like  CONCAT('%',#{id},'%')</if>" +
            "<if test=\"name != null\"> AND user_name like  CONCAT('%', #{name},'%') </if>" +
            "order by user_status" +
            "</script>"
    })
    @ResultMap("userMap")
    //搜索用户
    Page<User> searchUsers(User user );

    @Select(" select * from user where user_id=#{id}")
    @ResultMap("userMap")
    //根据用户id查询用户信息
    User findById(Integer id);

    @Select("select count(user_name) from user where user_name=#{name}")
    //检查用户名是否已经存在
    Integer checkName(String name);

    @Select("select count(user_email) from user where user_email=#{email}")
    //检查用户邮箱是否已经存在
    Integer checkEmail(String email);
}
