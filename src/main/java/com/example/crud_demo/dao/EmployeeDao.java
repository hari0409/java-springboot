package com.example.crud_demo.dao;

import java.util.List;

import com.example.crud_demo.entity.Employee;

public interface EmployeeDao {
    List<Employee> findAll();

    Employee findById(Integer id);

    Employee save(Employee employee);

    void delete(Integer id);
}
