package com.example.demo_crud.routes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_crud.constants.ProjectConstants;
import com.example.demo_crud.exceptions.GlobalCustomException;
import com.example.demo_crud.pojo.Student;
import com.example.demo_crud.response.ErrorResponseObject;
import com.example.demo_crud.response.ResponseObject;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class SampleRoute {
    private List<Student> theStudents;

    @PostConstruct
    public void loadData() {
        List<Student> studs = new ArrayList<Student>();
        studs.add(new Student("Charles", "Bob"));
        studs.add(new Student("Mario", "Johnson"));
        studs.add(new Student("Self", "Smith"));
        this.theStudents = studs;
    }

    @ExceptionHandler(exception = GlobalCustomException.class)
    public ResponseEntity<ErrorResponseObject> handleException(GlobalCustomException e) {
        return ResponseEntity.status(e.statusCode)
                .body(new ErrorResponseObject(ProjectConstants.FAILURE, e.getMessage()));
    }

    @ExceptionHandler(exception = GlobalCustomException.class)
    public ResponseEntity<ErrorResponseObject> handleExceptionGeneric(Exception e) {
        return ResponseEntity.status(404)
                .body(new ErrorResponseObject(ProjectConstants.FAILURE, e.getMessage()));
    }

    // Way 1
    @GetMapping("/students/{studentId}")
    public ResponseEntity<ResponseObject<Student>> getStudent(@PathVariable Integer studentId) {
        try {
            return ResponseEntity.status(200)
                    .body(new ResponseObject<Student>(ProjectConstants.SUCCESS, theStudents.get(studentId)));
        } catch (Exception e) {
            return ResponseEntity.status(404)
                    .body(new ResponseObject<Student>(ProjectConstants.FAILURE, null, "Student Record Id Not Found"));
        }
    }

    // Way 2
    @GetMapping("/getstudents/{studentId}")
    public ResponseEntity<ResponseObject<Student>> getStudentCustom(@PathVariable Integer studentId) {
        if (studentId >= this.theStudents.size() || studentId < 0) {
            throw new GlobalCustomException("Student with " + studentId + "doesnt exists", 404);
        }
        return ResponseEntity.status(200)
                .body(new ResponseObject<Student>(ProjectConstants.SUCCESS, this.theStudents.get(studentId + 1)));
    }
}