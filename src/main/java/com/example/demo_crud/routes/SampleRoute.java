package com.example.demo_crud.routes;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SampleRoute {

    // Normal Params
    @GetMapping("/student")
    public ResponseEntity<String> getParamsStudent(@RequestParam String name, @RequestParam Integer age) {
        return ResponseEntity.status(201).body("Name: " + name + " Age: " + age);
    }

    // Names Params
    @GetMapping("/teacher")
    public ResponseEntity<String> getParamsTeacher(@RequestParam(name = "name") String teacherName,
            @RequestParam(name = "age") Integer teacherAge) {
        return ResponseEntity.status(201).body("Name: " + teacherName + " Age: " + teacherAge);
    }

    // Required & Default Value
    @GetMapping("/janitor")
    public ResponseEntity<String> getParamExtra(@RequestParam(required = false, defaultValue = "NONE") String name) {
        return ResponseEntity.status(201).body("Janitor: " + name);
    }

    // Map of params
    @GetMapping("/principle")
    public ResponseEntity<String> getParamMap(@RequestParam Map<String, String> paramMap) {
        return ResponseEntity.status(201).body(paramMap.get("name") + " " + paramMap.get("age"));
    }
}
