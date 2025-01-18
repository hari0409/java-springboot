package com.example.demo_crud;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo_crud.dao.StudentDao;
import com.example.demo_crud.entity.Student;

@SpringBootApplication
public class DemoCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner -> {
			createStudent(studentDao);
			findStudent(studentDao, 200);
		};
	}

	private void findStudent(StudentDao studentDao, int i) {
		System.out.println(studentDao.findById(i));
		System.out.println(Student.class);
	}

	private void createStudent(StudentDao studentDao) {
		Student s = new Student("Chad", "IDK", "chad@gmail.com");
		studentDao.save(s);
		System.out.println(s.getId());
	}
}
