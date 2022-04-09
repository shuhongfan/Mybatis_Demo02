package com.itheima.pojo;

/**
 * 员工持久化类
 */
public class Worker {
    private Integer id;         //主键
    private String name;        //姓名
    private Integer age;        //年龄
    private String sex;         //性别
    private String worker_id;   //工号

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getWorker_id() {
        return worker_id;
    }

    public void setWorker_id(String worker_id) {
        this.worker_id = worker_id;
    }

    @Override
    public String toString() {
        return "Worker{" + "id=" + id + ", name=" + name +
                ", age=" + age + ", sex=" + sex + ", worker_id=" + worker_id + '}';
    }
}

