package com.departmentService.service;

import com.departmentService.model.Department;
import com.departmentService.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository repository;

    public Department saveDepartmentDetails(Department department) {
        return repository.save(department);
    }

    public List<Department> uploadDepartments(List<Department> departments){
        return repository.saveAll(departments);
    }

    public Optional<Department> getDepartmentDetails(Long dept_id){
        return repository.findById(dept_id);
    }


}
