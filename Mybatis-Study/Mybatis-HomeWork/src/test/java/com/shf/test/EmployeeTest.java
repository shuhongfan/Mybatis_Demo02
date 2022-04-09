package com.shf.test;

import com.shf.mapper.EmployeeMapper;
import com.shf.pojo.Employee;
import com.shf.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class EmployeeTest {
    @Test
    public void selectEmployeeList() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employees = mapper.selectEmployeeList();
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        sqlSession.close();
    }

    @Test
    public void selectEmployeeById() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.selectEmployeeById(1);
        System.out.println(employee);

        sqlSession.close();
    }

    @Test
    public void addEmployee() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = new Employee(5, "张帅", 39, "总监");
        mapper.addEmployee(employee);

        sqlSession.close();
    }

    @Test
    public void updateEmployee() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = new Employee(5, "张帅new", 93, "总监new");
        mapper.updateEmployee(employee);

        sqlSession.close();
    }


    @Test
    public void deleteEmployeeById() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        mapper.deleteEmployeeById(5);

        sqlSession.close();
    }
}
