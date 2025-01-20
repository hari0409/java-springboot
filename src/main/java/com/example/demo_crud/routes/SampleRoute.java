package com.example.demo_crud.routes;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
