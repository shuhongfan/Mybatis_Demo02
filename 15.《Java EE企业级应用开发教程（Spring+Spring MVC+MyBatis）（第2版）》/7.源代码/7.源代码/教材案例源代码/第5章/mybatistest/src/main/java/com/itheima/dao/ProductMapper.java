package com.itheima.dao;

import com.itheima.pojo.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper {
    @Select("select * from tb_product where id in (select product_id from " +
            "tb_ordersitem where orders_id = #{id} )")
    List<Product> selectProductByOrdersId(int orders_id);
}

