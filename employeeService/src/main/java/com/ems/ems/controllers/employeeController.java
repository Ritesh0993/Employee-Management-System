package com.ems.ems.controllers;

import com.ems.ems.models.Employee;
import com.ems.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee/")
public class employeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/test")
    public String test() {
        return "Employee Controller Working...!";
    }

    @PostMapping("save")
    public ResponseEntity<Employee> saveEmployeeDetails(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    @PostMapping("saveall")
    public ResponseEntity<List<Employee>> saveBulkEmployeeDetails(@RequestBody List<Employee> employee) {
        List<Employee> savedEmployee = employeeService.saveBulkEmployeeData(employee);
        return ResponseEntity.ok(savedEmployee);
    }

}
