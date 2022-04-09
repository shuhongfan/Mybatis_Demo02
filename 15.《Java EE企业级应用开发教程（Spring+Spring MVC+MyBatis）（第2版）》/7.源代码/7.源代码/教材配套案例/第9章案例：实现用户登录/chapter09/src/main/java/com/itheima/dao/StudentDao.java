package com.itheima.dao;

import com.itheima.entity.Student;

import java.util.List;

public interface StudentDao {
    //查询所有账户
    public List<Student> findAllStudent();
}

