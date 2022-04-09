package com.itheima.pojo;

/**
 * 员工持久化类
 */
public class Employee {
    private Integer id;        // 主键id
    private String name;        // 姓名
    private Integer age;        // 年龄
    private String position;    // 职位

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name +
                ", age=" + age + ", position=" + position + '}';
    }
}

