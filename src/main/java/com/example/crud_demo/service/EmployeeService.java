package com.example.crud_demo.service;

import java.util.List;

import com.example.crud_demo.entity.Employee;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(Integer id);

    Employee save(Employee employee);

    void delete(Integer id);
}
