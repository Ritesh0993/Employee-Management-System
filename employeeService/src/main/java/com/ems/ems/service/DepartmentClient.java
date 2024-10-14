package com.ems.ems.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="DEPARTMENTSERVICE")
public interface DepartmentClient {
    @GetMapping("/dept/department/{deptid}")
    String getEmployeeDeptDetails(@PathVariable Long deptid);
}
