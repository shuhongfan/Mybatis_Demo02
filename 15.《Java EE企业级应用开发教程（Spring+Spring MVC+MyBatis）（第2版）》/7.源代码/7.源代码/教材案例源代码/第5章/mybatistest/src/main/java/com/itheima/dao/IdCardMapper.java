package com.itheima.dao;

import com.itheima.pojo.IdCard;
import org.apache.ibatis.annotations.Select;

public interface IdCardMapper {
    @Select("select * from tb_idcard where id=#{id}")
    IdCard selectIdCardById(int id);
}

