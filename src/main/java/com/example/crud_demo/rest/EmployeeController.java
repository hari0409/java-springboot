package com.example.crud_demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud_demo.constants.ProjectConstant;
import com.example.crud_demo.entity.Employee;
import com.example.crud_demo.exception.GlobalException;
import com.example.crud_demo.responseObject.ResponseObject;
import com.example.crud_demo.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    public EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<ResponseObject<List<Employee>>> getAllEmployees() {
        return ResponseEntity.status(200)
                .body(new ResponseObject<List<Employee>>(ProjectConstant.SUCCESS, employeeService.findAll()));
    }

    @GetMapping("/{id:[0-9]+}")
    public ResponseEntity<ResponseObject<Employee>> getEmployeeById(@PathVariable Integer id) {
        Employee emp = employeeService.findById(id);
        if (emp == null) {
            throw new GlobalException("Employee Not Found for the Id: " + id, 404);
        }
        return ResponseEntity.status(200)
                .body(new ResponseObject<Employee>(ProjectConstant.SUCCESS, emp));
    }

    @PostMapping
    public ResponseEntity<ResponseObject<Employee>> createEmployee(@RequestBody Employee emp) {
        Employee createdEmployee = employeeService.save(emp);
        return ResponseEntity.status(201).body(new ResponseObject<Employee>(ProjectConstant.SUCCESS, createdEmployee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject<Employee>> updateEmployee(@RequestBody Employee emp,
            @PathVariable Integer id) {
        emp.setId(id);
        Employee createdEmployee = employeeService.save(emp);
        return ResponseEntity.status(201).body(new ResponseObject<Employee>(ProjectConstant.SUCCESS, createdEmployee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject<String>> deleteString(@PathVariable Integer id) {
        employeeService.delete(id);
        return ResponseEntity.status(201).body(new ResponseObject<String>(ProjectConstant.SUCCESS, "Employee Deleted"));
    }
}
