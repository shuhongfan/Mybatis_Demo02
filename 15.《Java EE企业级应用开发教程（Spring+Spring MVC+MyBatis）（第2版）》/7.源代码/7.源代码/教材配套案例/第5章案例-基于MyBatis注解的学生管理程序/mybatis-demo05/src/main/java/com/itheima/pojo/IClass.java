package com.itheima.pojo;

import java.util.List;

/**
 * 班级持久化类
 */
public class IClass {
    private Integer id;                       // 主键id
    private String classname;                // 班级名称
    private List<IStudent> studentList;    // 学生集合

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public List<IStudent> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<IStudent> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "IClass{" +
                "id=" + id +
                ", classname='" + classname +
                ", studentList=" + studentList + '}';
    }
}

