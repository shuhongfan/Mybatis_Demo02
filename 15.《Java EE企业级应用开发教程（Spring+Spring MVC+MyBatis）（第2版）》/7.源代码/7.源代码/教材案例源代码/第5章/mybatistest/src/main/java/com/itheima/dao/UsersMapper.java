package com.itheima.dao;

import com.itheima.pojo.Users;
import org.apache.ibatis.annotations.*;

public interface UsersMapper {
    @Select("select * from tb_user where id=#{id} ")
    @Results({@Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "address", property = "address"),
            @Result(column = "id", property = "ordersList",
                    many = @Many(select =
                            "com.itheima.dao.OrdersMapper.selectOrdersByUserId"))})
    Users selectUserById(int id);
}

