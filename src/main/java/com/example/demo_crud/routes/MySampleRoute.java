package com.example.demo_crud.routes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_crud.dao.StudentDao;
import com.example.demo_crud.entity.Student;

@RestController
public class MySampleRoute {
    private StudentDao sdao;

    @Autowired
    public MySampleRoute(StudentDao sdao) {
        this.sdao = sdao;
    }

    @GetMapping("/getall")
    public List<Student> getAllStudents() {
        return sdao.findAllStudents();
    }
}
