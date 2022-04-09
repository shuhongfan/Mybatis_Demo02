package com.itheima.dao;

import com.itheima.pojo.Person;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface PersonMapper {
    @Select("select * from tb_person where id=#{id}")
    @Results({@Result(column = "card_id", property = "card",
            one = @One(select =
                    "com.itheima.dao.IdCardMapper.selectIdCardById"))})
    Person selectPersonById(int id);
}

