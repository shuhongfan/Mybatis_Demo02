package com.shf.mapper;

import com.shf.pojo.DepartmentSy4;
import com.shf.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class DepartmentSy4MapperTest {

    @Test
    public void getStudent() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        DepartmentSy4Mapper mapper = sqlSession.getMapper(DepartmentSy4Mapper.class);
        List<DepartmentSy4> department = mapper.getDepartment(1);
        department.forEach(System.out::println);

        sqlSession.close();
    }
}