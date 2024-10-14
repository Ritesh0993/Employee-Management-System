package com.ems.ems.controllers;

import com.ems.ems.models.Employee;
import com.ems.ems.service.DepartmentClient;
import com.ems.ems.service.EmployeeService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/employee/")
public class employeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DepartmentClient departmentClient;

  //  private final WebClient webClient = WebClient.create();

    @Autowired
    private WebClient.Builder webClientBuilder;

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

    /**
     * Calling Department Service through Eureka Server using Rest Template
     *
     * @param deptid
     * @return
     */
    @GetMapping("/deptRest/{deptid}")
    public String getEmployeeDeptDetailsUsingRestTemplate(@PathVariable Long deptid) {
        String url = "http://DEPARTMENTSERVICE/dept/department/" + deptid;
        String deptDetails = restTemplate.getForObject(url, String.class);
        return "Department details : " + deptDetails;

    }

    /**
     * Calling Department Service through Eureka Server using Feign Client
     *
     * @param deptid
     * @return
     */
    @GetMapping("/deptfeign/{deptid}")
    public String getEmployeeDeptDetailsUsingFeignClient(@PathVariable Long deptid) {
        String deptDetails = departmentClient.getEmployeeDeptDetails(deptid);
        return "Department details : " + deptDetails;
    }

    /**
     *  Calling Department Service through Eureka Server using Web Client
     * @param deptid
     * @return
     */
    @GetMapping("/webclient/{deptid}")
    public Mono<String> getEmployeeDeptDetailsUsingWebClient(@PathVariable Long deptid) {
        System.out.println("Dept id : "+deptid);
        return webClientBuilder.build()
                .get()
                .uri("http://DEPARTMENTSERVICE/dept/department/"+deptid)
                .retrieve()
                .bodyToMono(String.class);

    }






}
