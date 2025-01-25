package com.example.crud_demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.crud_demo.entity.Employee;

import jakarta.persistence.EntityManager;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    public EntityManager em;

    @Autowired
    public EmployeeDaoImpl(EntityManager em) {
        this.em = em;
    }

    public List<Employee> findAll() {
        return em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
    }

    public Employee findById(Integer id) {
        return em.find(Employee.class, id);
    }

    public Employee save(Employee employee) {
        Employee savedEmployee = em.merge(employee);
        return savedEmployee;
    }

    public void delete(Integer id) {
        em.remove(findById(id));
    }
}
