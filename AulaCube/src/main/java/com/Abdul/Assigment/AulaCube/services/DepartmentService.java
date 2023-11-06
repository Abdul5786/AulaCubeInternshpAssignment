package com.Abdul.Assigment.AulaCube.services;

import com.Abdul.Assigment.AulaCube.dtos.DepartmentDtos;

import java.util.List;

public interface DepartmentService
{
    DepartmentDtos addDepartment(DepartmentDtos departmentDtos); // to add dpt in the db
    DepartmentDtos getDepartmentById(Long deptId); // to get dpt by id
    List<DepartmentDtos> getListOfDepartment(); // to get list of departments
    DepartmentDtos updateDepartmentById(DepartmentDtos departmentDtos,Long deptId); // to update dpt by id
    void deleteDepartmentById(Long deptId);  // to delete dpt by id
}
