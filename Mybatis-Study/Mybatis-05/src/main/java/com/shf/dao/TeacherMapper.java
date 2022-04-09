package com.shf.dao;

import com.shf.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {
    Teacher getTeacher(@Param("id") int id);

    Teacher getTeacher2(@Param("id") int id);

}
