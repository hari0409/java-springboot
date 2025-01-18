package com.example.demo_crud.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo_crud.entity.Student;

import jakarta.persistence.EntityManager;

@Repository
public class StudentDaoImpl implements StudentDao {
    EntityManager em;

    @Autowired
    public StudentDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void save(Student s) {
        em.persist(s);
    }

    @Override
    public Student findById(Integer Id) {
        return em.find(Student.class, Id);
    }

}
