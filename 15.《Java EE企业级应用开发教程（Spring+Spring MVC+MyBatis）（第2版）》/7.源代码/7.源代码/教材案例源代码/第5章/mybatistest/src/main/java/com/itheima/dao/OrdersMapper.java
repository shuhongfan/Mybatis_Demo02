package com.itheima.dao;

import com.itheima.pojo.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrdersMapper {
    @Select("select * from tb_orders where user_id=#{id} ")
    @Results({@Result(id = true, column = "id", property = "id"),
            @Result(column = "number", property = "number")
    })
    List<Orders> selectOrdersByUserId(int user_id);

    @Select("select * from tb_orders where id=#{id} ")
    @Results({@Result(id = true, column = "id", property = "id"),
            @Result(column = "number", property = "number"),
            @Result(column = "id", property = "productList",
                    many = @Many(select =
                            "com.itheima.dao.ProductMapper.selectProductByOrdersId"))})
    Orders selectOrdersById(int id);

}

