package com.shf.test;

import com.shf.mapper.StudentsMapper;
import com.shf.pojo.Students;
import com.shf.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class StudentsTest {

    // 查询所有学生
    @Test
    public void getStudentList() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentsMapper mapper = sqlSession.getMapper(StudentsMapper.class);
        List<Students> studentList = mapper.getStudentList();
        for (Students student : studentList) {
            System.out.println(student);
        }

        sqlSession.close();
    }

    //    根据sno查询学生
    @Test
    public void getStudentById() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentsMapper mapper = sqlSession.getMapper(StudentsMapper.class);
        Students studentById = mapper.getStudentById(1);
        System.out.println(studentById);

        sqlSession.close();
    }

    //    添加学生
    @Test
    public void addStudent() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentsMapper mapper = sqlSession.getMapper(StudentsMapper.class);

        Students student = new Students(
                (int) (Math.random() * 10000),
                "王六",
                1,
                new Date(),
                "软件工程");
        System.out.println(student);

        mapper.addStudent(student);

        sqlSession.close();
    }

    //    更新学生信息
    @Test
    public void updateStudent() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentsMapper mapper = sqlSession.getMapper(StudentsMapper.class);

        Students student = new Students();
        student.setSno(1);
        student.setMajor("java");
        System.out.println(student);

        mapper.updateStudent(student);

        sqlSession.close();
    }

    //    删除学生
    @Test
    public void deleteStudent() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentsMapper mapper = sqlSession.getMapper(StudentsMapper.class);

        mapper.deleteStudent(6);

        sqlSession.close();
    }

    //    查询所有女生的信息
    @Test
    public void getStudent() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentsMapper mapper = sqlSession.getMapper(StudentsMapper.class);

        Students students = new Students();
        students.setSsex(0);
        List<Students> studentList = mapper.getStudent(students);
        for (Students student : studentList) {
            System.out.println(student);
        }

        sqlSession.close();
    }

}
