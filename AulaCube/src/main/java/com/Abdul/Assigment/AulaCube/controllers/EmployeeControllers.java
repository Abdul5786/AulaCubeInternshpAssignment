package com.Abdul.Assigment.AulaCube.controllers;

import com.Abdul.Assigment.AulaCube.dtos.ApiResponse;
import com.Abdul.Assigment.AulaCube.dtos.EmployeeDto;
import com.Abdul.Assigment.AulaCube.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employee")
public class EmployeeControllers
{
    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/add")
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto)
    {
        EmployeeDto savedEmp = employeeService.AddEmployee(employeeDto);
        return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
    }
    @GetMapping(value = "/get/{empId}")
    public  ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long empId)
    {
        EmployeeDto emp = employeeService.getEmployeeById(empId);
        return new ResponseEntity<>(emp,HttpStatus.FOUND);
    }
    @GetMapping(value = "getAll")
    public ResponseEntity<List<EmployeeDto>> getAllListOfEmployee()
    {
        List<EmployeeDto> listOfEmployees = employeeService.getListOfEmployees();
        return ResponseEntity.ok(listOfEmployees);
    }
    @PutMapping(value = "/update/{empId}")
    public ResponseEntity<EmployeeDto> updateEmpById(@RequestBody EmployeeDto employeeDto,@PathVariable Long empId)
    {
        EmployeeDto updatedEmp = employeeService.updateEmployeeById(employeeDto, empId);
        return ResponseEntity.ok(updatedEmp);
    }
    @DeleteMapping(value = "/delete/{empId}")
    public  ResponseEntity<ApiResponse> deleteEmpById(@PathVariable Long empId)
    {
            employeeService.deleteEmpById(empId);
            return new ResponseEntity<>( new ApiResponse
                    ("Employee Deleted Successfully",true),HttpStatus.OK);
    }

}
