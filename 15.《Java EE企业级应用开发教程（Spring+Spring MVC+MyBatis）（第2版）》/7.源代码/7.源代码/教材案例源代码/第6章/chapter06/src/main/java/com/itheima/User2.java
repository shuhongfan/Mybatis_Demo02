package com.itheima;
public class User2 {
    private int id;
    private String name;
    private String password;
    public void setId(int id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String toString(){
        return "id="+id+",name="+name+",password="+password;
    }
}