package com.shf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentSy4 implements Serializable {
    private Integer dno;
    private String dname;

    private List<StudentSy4> students;
}
