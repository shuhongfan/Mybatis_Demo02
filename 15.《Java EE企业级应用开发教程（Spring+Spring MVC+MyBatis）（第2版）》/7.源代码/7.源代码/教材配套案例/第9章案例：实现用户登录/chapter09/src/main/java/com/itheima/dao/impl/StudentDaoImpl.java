package com.itheima.dao.impl;

import com.itheima.dao.StudentDao;
import com.itheima.entity.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    // 声明JdbcTemplate属性及其setter方法
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 查询所有用户信息
    public List<Student> findAllStudent() {
        // 定义SQL语句
        String sql = "select * from student";
        // 创建一个新的BeanPropertyRowMapper对象
        RowMapper<Student> rowMapper =
                new BeanPropertyRowMapper<Student>(Student.class);
        // 执行静态的SQL查询，并通过RowMapper返回结果
        return this.jdbcTemplate.query(sql, rowMapper);
    }
}

