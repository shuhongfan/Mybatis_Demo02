package com.shf.mapper;

import com.shf.pojo.StudentSy4;
import com.shf.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;


public class StudentSy4MapperTest {

    @Test
    public void addStudent() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentSy4Mapper mapper = sqlSession.getMapper(StudentSy4Mapper.class);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2020);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 3);
        Date dateRepresentation = cal.getTime();
        StudentSy4 studentSy4 = new StudentSy4(
                220633,
                "Tom",
                1,
                dateRepresentation,
                "广州",
                "计算机科学与技术",
                1
        );
        mapper.addStudent(studentSy4);

        sqlSession.close();
    }
}