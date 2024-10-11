package com.departmentService.controller;

import com.departmentService.model.Department;
import com.departmentService.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dept/")
public class DepartmentController {
    @Autowired
    private DepartmentService service;


    @PostMapping("/savedept")
    public ResponseEntity<Department> saveDepartmentDetails(@RequestBody Department department){
        Department savedDept = service.saveDepartmentDetails(department);
        return ResponseEntity.ok(savedDept);
    }

    @PostMapping("/upload/departments")
    public ResponseEntity<List<Department>> uploadBulkDepartments(@RequestBody List<Department> departments){
        List<Department> savedDept = service.uploadDepartments(departments);
        return ResponseEntity.ok(savedDept);
    }

    public ResponseEntity<Department> getDepartmentDetails(@PathVariable("deptid") Long deptid){
        Optional<Department> deptDetails = service.getDepartmentDetails(deptid);
        return ResponseEntity.ok(deptDetails.get());
    }




}
