package com.Abdul.Assigment.AulaCube.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "employee_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employees
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;
    @Column(name = "firstname",length = 255,nullable = false)
    private String firstName;
    @Column(name = "lastname",length = 255,nullable = false)
    private String lasName;
    @Column(name = "email",length = 255,nullable = false)
    private String email;
    @Column(name = "department")
    private String departmentId;
    private  Date createdAt;
    private  Date updatedAt;
}
