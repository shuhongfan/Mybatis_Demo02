package com.shf.mapper;

import com.shf.pojo.StudentSy5;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentSy5Mapper {
    @Select("select * from studentsy5 where id=#{id};")
    StudentSy5 selectStudentById(Integer id);

    @Select("update studentsy5 set name = #{name},age=#{age} where id=#{id};")
    void updateStudentById(StudentSy5 studentSy5);

    @Select("select s.id id,s.name,s.age,c.classname className,c.id classID from studentsy5 s,classsy5 c where s.class_id=c.id and classname=#{classname};")
    List<StudentSy5> selectStudentListByClassName(String className);
}
