package com.example.demo_crud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo_crud.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

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

    @Override
    public List<Student> findAllStudents() {
        TypedQuery<Student> findAllQuery = em.createQuery("FROM Student WHERE email LIKE :emailVar", Student.class);
        findAllQuery.setParameter("emailVar", "%hari%");
        return findAllQuery.getResultList();
    }

    public List<Student> findAllStudentStrict() {
        TypedQuery<Student> findAllStrict = em.createQuery("SELECT s FROM Student s WHERE s.email LIKE :emailFilter", Student.class);
        findAllStrict.setParameter("emailFilter","%hari%");
        return findAllStrict.getResultList();
    }

}
