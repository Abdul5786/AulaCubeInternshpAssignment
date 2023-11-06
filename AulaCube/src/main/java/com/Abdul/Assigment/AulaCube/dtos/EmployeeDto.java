package com.Abdul.Assigment.AulaCube.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto
{
    private String firstName;
    private String lasName;
    private String email;
    private String departmentId;
    private Date createdAt;
    private Date updatedAt;
}
