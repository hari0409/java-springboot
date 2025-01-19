package com.example.demo_crud;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
		};
	}

	private void createStudent(StudentDao studentDao) {
		Student s = new Student(
				UUID.randomUUID().toString().substring(0, 10).toUpperCase(),
				UUID.randomUUID().toString().substring(0, 5).toUpperCase(),
				UUID.randomUUID().toString().substring(0, 15) + "@gmail.com");
		System.out.println(UUID.randomUUID().toString());
		studentDao.save(s);
		System.out.println(s.getId());
	}
}
