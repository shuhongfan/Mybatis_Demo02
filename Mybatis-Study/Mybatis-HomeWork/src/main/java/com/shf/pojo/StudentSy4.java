package com.shf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentSy4 implements Serializable {
    private Integer sno;
    private String sname;
    private Integer ssex;
    private Date birthday;
    private String local;
    private String major;
    private Integer department;
}
