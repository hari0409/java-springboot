package com.example.crud_demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.crud_demo.dao.EmployeeDao;
import com.example.crud_demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    public EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return employeeDao.findById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        Employee savedEmployee = employeeDao.save(employee);
        return savedEmployee;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        employeeDao.delete(id);
    }

}
