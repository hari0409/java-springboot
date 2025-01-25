package com.example.crud_demo.jpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud_demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    
}