package com.itheima;
public class User1 {
    private int id;
    private String name;
    private String password;
    //有参构造方法
    public User1(int id, String name, String password){
        this.id=id;
        this.name=name;
        this.password=password;
    }
    public String toString(){
        return "id="+id+",name="+name+",password="+password;
    }
}