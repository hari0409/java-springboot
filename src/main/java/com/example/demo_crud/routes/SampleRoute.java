package com.example.demo_crud.routes;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_crud.constants.ProjectConstants;
import com.example.demo_crud.entity.Teacher;
import com.example.demo_crud.exceptions.GlobalCustomException;
import com.example.demo_crud.response.ResponseObject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@RestController
@RequestMapping("/api")
public class SampleRoute {
    private EntityManager em;

    SampleRoute(EntityManager em) {
        this.em = em;
    }

    // Normal Params
    @GetMapping("/student")
    @Transactional
    public ResponseEntity<ResponseObject<List<Teacher>>> getParamsStudent() {
        try {
            Teacher t = new Teacher("Hari Baskar", "S", 10, "Biology");
            em.persist(t);
            TypedQuery<Teacher> teacherTypedQuery = em.createQuery("SELECT t FROM Teacher t", Teacher.class);
            List<Teacher> teachers = teacherTypedQuery.getResultList();
            ResponseObject<List<Teacher>> ro = new ResponseObject<>(ProjectConstants.SUCCESS, teachers);
            return ResponseEntity.status(201).body(ro);
        } catch (Exception e) {
            ResponseObject<List<Teacher>> ro = new ResponseObject<>(ProjectConstants.FAILURE, null, e.getMessage());
            return ResponseEntity.status(201).body(ro);
        }
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
