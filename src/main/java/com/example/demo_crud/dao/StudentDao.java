package com.example.demo_crud.dao;

import java.util.List;

import com.example.demo_crud.entity.Student;

public interface StudentDao {
    void save(Student s);

    Student findById(Integer Id);

    List<Student> findAllStudents();

    List<Student> findAllStudentStrict();
}
