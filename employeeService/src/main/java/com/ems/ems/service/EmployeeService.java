package com.ems.ems.service;

import com.ems.ems.models.Employee;
import com.ems.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);

    }

    public List<Employee> saveBulkEmployeeData(List<Employee> employee){
        return employeeRepository.saveAll(employee);

    }

    public Optional<Employee> getEmployeeById(Long employeeId){
        return employeeRepository.findById(employeeId);
    }

    public List<Employee> getAllEmployeeList(){
        return employeeRepository.findAll();
    }



}
