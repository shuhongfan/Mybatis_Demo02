package com.shf.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Users implements Serializable {
    private int uid;                  // 用户id
    private String uname;      // 用户姓名
    private int uage;              // 用户年龄

}
