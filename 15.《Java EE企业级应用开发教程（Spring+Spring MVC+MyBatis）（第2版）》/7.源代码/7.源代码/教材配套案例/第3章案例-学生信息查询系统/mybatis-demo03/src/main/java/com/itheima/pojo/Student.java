package com.itheima.pojo;

/**
 * 学生持久化类
 */
public class Student {
    private Integer id;        //主键id
    private String name;      // 姓名
    private String major;     // 专业
    private String sno;        // 学号

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id +
                ", name='" + name + ", major=" + major +
                ", sno=" + sno + '}';
    }
}

