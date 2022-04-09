package com.shf.mapper;

import com.shf.pojo.Students;

import java.util.List;

public interface StudentsMapper {

    List<Students> getStudentList();

    Students getStudentById(int sno);

    void addStudent(Students students);

    void updateStudent(Students students);

    void deleteStudent(int sno);

    List<Students> getStudent(Students students);
}
