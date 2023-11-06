package com.Abdul.Assigment.AulaCube.controllers;

import com.Abdul.Assigment.AulaCube.dtos.ApiResponse;
import com.Abdul.Assigment.AulaCube.dtos.DepartmentDtos;
import com.Abdul.Assigment.AulaCube.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartMentControllers
{
    @Autowired
    private DepartmentService  departmentService;

    @PostMapping(value = "/add")
    public ResponseEntity<DepartmentDtos> addDepartment(@RequestBody DepartmentDtos departmentDtos)
    {
        DepartmentDtos department = departmentService.addDepartment(departmentDtos);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }
    @GetMapping(value = "/get/{deptId}")
    public ResponseEntity<DepartmentDtos> getDepartmentById(@PathVariable Long deptId)
    {
        DepartmentDtos departmentById = departmentService.getDepartmentById(deptId);
        return new ResponseEntity<>(departmentById,HttpStatus.FOUND);
    }
    @GetMapping(value = "/getAll")
    public ResponseEntity<List<DepartmentDtos>> getListOfDepartment()
    {
        List<DepartmentDtos> listOfDepartment = departmentService.getListOfDepartment();
        return  ResponseEntity.ok(listOfDepartment);
    }
    @PutMapping(value = "/update/{deptId}")
    public ResponseEntity<DepartmentDtos> updateDepartmentById(@RequestBody DepartmentDtos departmentDtos, @PathVariable Long deptId)
    {
        DepartmentDtos department = departmentService.updateDepartmentById(departmentDtos, deptId);
       return ResponseEntity.ok(department);
    }
     @DeleteMapping(value = "/delete/{deptId}")
    public ResponseEntity<ApiResponse> deleteDeptById(@PathVariable Long deptId)
    {
           departmentService.deleteDepartmentById(deptId);
           return new ResponseEntity<>( new ApiResponse("Department deleted successfully",true),HttpStatus.OK);
    }

}
