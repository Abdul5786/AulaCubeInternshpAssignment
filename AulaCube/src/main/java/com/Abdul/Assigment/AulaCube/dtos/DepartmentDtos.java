package com.Abdul.Assigment.AulaCube.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DepartmentDtos
{
    private Long departmentId;
    private String departmentName;
    private Date createDate;
    private Date updatedDate;

}
