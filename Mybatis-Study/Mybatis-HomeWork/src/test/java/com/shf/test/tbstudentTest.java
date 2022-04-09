package com.shf.test;

import com.shf.mapper.TbStudentMapper;
import com.shf.pojo.tb_student;
import com.shf.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class tbstudentTest {
    @Test
    public void getStudentListByConditions() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        TbStudentMapper mapper = sqlSession.getMapper(TbStudentMapper.class);

        tb_student tbstudent = new tb_student();
        tbstudent.setName("张三");
        tbstudent.setMajor("软件工程");
        List<tb_student> tbstudentListByConditions = mapper.getStudentListByConditions(tbstudent);
        tbstudentListByConditions.forEach(System.out::println);

        sqlSession.close();
    }

    @Test
    public void getStudentById() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        TbStudentMapper mapper = sqlSession.getMapper(TbStudentMapper.class);
        List<tb_student> studentById = mapper.getStudentByLTId(5);
        studentById.forEach(System.out::println);

        sqlSession.close();
    }

    @Test
    public void addStudent() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        TbStudentMapper mapper = sqlSession.getMapper(TbStudentMapper.class);

        tb_student student1 = new tb_student();
        student1.setId(100);
        student1.setName("tom");
        mapper.addStudent(student1);

        tb_student student2 = new tb_student();
        student2.setName("jack");
        mapper.addStudent(student2);

        tb_student student3 = new tb_student();
        student3.setName("mike");
        student3.setMajor("计算机科学与技术");
        mapper.addStudent(student3);

        sqlSession.close();
    }
}
