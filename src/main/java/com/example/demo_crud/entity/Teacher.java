package com.example.demo_crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @Column(name = "teacherUUID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer teacherUUID;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "subject")
    private String subject;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, Integer age, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.subject = subject;
    }

    public Teacher(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getTeacherUUID() {
        return teacherUUID;
    }

    public void setTeacherUUID(Integer teacherUUID) {
        this.teacherUUID = teacherUUID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Teacher [teacherUUID=" + teacherUUID + ", firstName=" + firstName + ", lastName=" + lastName + ", age="
                + age + ", subject=" + subject + "]";
    };

}
