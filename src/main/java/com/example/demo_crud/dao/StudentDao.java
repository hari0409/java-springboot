package com.example.demo_crud.dao;

import java.util.List;

import com.example.demo_crud.entity.Student;

public interface StudentDao {
    void save(Student s);

    Student findById(Integer Id);

    List<Student> findAllStudents();

    List<Student> findAllStudentStrict();

    void updateStudent(Student student);

    void bulkUpdateEmail(String findEmailString, String replaceEmailString);

    void deleteStudent(Student s);

    void bulkDelete(int id);
}
