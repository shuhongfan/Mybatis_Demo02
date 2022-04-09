package com.shf.mapper;


import com.shf.pojo.tb_student;

import java.util.List;

public interface TbStudentMapper {
    //    多条件查询
    List<tb_student> getStudentListByConditions(tb_student tbstudent);

    //    单条件查询
    List<tb_student> getStudentByLTId(Integer id);

    void addStudent(tb_student tb_student);
}
