package com.example.demo_crud.dao;

import com.example.demo_crud.entity.Student;

public interface StudentDao {
    void save(Student s);

    Student findById(Integer Id);
}
