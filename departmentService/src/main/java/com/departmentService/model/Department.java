package com.departmentService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dept_Id;
    @Column(name="dept_name")
    private String name;
    @Column(name="dept_location")
    private String location;
    @Column(name="dept_hod")
    private String hod;
    @Column(name="created_on")
    private String createdAt;

}
