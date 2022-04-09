package com.itheima.dao;

import com.itheima.pojo.IStudent;
import org.apache.ibatis.annotations.Select;

public interface IStudentMapper {
    @Select("select * from s_student where id = #{id}")
    IStudent selectStudent(int id);
}

