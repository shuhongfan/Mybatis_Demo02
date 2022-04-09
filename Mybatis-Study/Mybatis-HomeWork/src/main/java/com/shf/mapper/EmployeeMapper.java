package com.shf.mapper;

import com.shf.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {
    //    查询所有员工
    List<Employee> selectEmployeeList();

    //    根据id查询员工信息
    Employee selectEmployeeById(Integer id);

    //    添加员工
    void addEmployee(Employee employee);

    //    根据Id修改员工信息
    void updateEmployee(Employee employee);

    //    根据id删除员工信息
    void deleteEmployeeById(Integer id);
}
