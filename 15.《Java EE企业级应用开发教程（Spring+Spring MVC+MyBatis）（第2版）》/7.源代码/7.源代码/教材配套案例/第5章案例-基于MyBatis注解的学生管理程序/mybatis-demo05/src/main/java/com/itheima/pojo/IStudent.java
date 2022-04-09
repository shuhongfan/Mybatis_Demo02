package com.itheima.pojo;

/**
 * 学生持久化类
 */
public class IStudent {
    private Integer id;       // 主键id
    private String name;      // 姓名
    private int age;           // 年龄

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id +
                ", name='" + name + ", age=" + age + '}';
    }
}

