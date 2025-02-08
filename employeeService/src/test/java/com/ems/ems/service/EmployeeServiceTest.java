package com.ems.ems.service;

import com.ems.ems.models.Employee;
import com.ems.ems.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService  employeeService;

    @Test
    public void testGetEmployeeDeptDetailsUsingRestTemplate(){
        Employee employee = new Employee();





    }




}
