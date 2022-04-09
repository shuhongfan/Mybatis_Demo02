package com.shf.dao;

import com.shf.pojo.Student;

import java.util.List;

public interface StudentMapper {

    //    查询所有的学生信息 以及对应的老师的信息
    List<Student> getStudent();

    List<Student> getStudent2();
}
