package com.shf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Students implements Serializable {
    private int sno;
    private String sname;
    private int ssex;
    private Date birthday;
    private String major;
}
