package com.shf.mapper;

import com.shf.pojo.StudentSy5;
import com.shf.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class StudentSy5MapperTest {

    @Test
    public void selectStudentById() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentSy5Mapper mapper = sqlSession.getMapper(StudentSy5Mapper.class);
        StudentSy5 studentSy5 = mapper.selectStudentById(2);
        System.out.println(studentSy5);

        sqlSession.close();
    }

    @Test
    public void updateStudentById() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentSy5Mapper mapper = sqlSession.getMapper(StudentSy5Mapper.class);

        StudentSy5 studentSy5 = new StudentSy5();
        studentSy5.setId(4);
        studentSy5.setName("李雷");
        studentSy5.setAge(21);
        mapper.updateStudentById(studentSy5);

        sqlSession.close();
    }

    @Test
    public void selectStudentListByClassName() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentSy5Mapper mapper = sqlSession.getMapper(StudentSy5Mapper.class);

        for (StudentSy5 sy5 : mapper.selectStudentListByClassName("二班")) {
            System.out.println(sy5);
        }

        sqlSession.close();
    }
}