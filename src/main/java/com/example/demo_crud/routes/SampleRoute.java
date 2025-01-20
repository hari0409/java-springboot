package com.example.demo_crud.routes;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_crud.pojo.Student;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
public class SampleRoute {

    @GetMapping("/students")
    public ResponseEntity<String> helloString(@RequestBody Map<String, Object> requestData) {
        String sender = (String) requestData.get("sender");
        System.out.println(sender);
        Integer age = (Integer) requestData.get("age");
        System.out.println(age);
        List<Student> students = (List<Student>) requestData.get("students");
        System.out.println(students);
        return ResponseEntity.status(201).body("Hello");
    }

    @GetMapping("/myStudent")
    public ResponseEntity<String> handleMyStudent(@RequestBody JsonNode requestBody) {
        String sender = requestBody.get("sender").asText();
        System.out.println(sender);
        Integer age = requestBody.get("age").asInt();
        System.out.println(age);
        // Traditional Data processing
        for (JsonNode stud : requestBody.get("students")) {
            Student s = new Student(stud.get("firstName").asText(), stud.get("lastName").asText());
            System.out.println(s);
        }
        // ObjectMapper Value Convert method
        ObjectMapper objMap = new ObjectMapper();
        List<Student> students = objMap.convertValue(
                requestBody.get("students"),
                objMap.getTypeFactory().constructCollectionType(List.class, Student.class));
        System.out.println(students);
        return ResponseEntity.ok().body("All Good");
    }

    // Working with Path Variables
    @GetMapping("/student/{studentId}")
    public ResponseEntity<String> getStudentDetail(@PathVariable String studentId) {
        return ResponseEntity.status(201).body("Student: " + studentId);
    }

    // Working with Path Variables
    @GetMapping("/student/{studentId}/{classGrp}")
    public ResponseEntity<String> getStudentDetailMap(@PathVariable Map<String, String> pathMap) {
        return ResponseEntity.status(201)
                .body("Student: " + pathMap.get("studentId") + " Group Nam: " + pathMap.get("classGrp"));
    }

    // RegEx with Path variables
    @GetMapping("/studentreg/{id:[0-9]+}")
    public ResponseEntity<String> getStudentRegex(@PathVariable String id) {
        return ResponseEntity.status(201)
                .body("Student: " + id);
    }
}
