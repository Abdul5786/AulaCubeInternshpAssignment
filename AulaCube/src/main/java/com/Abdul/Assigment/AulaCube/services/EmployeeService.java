package com.Abdul.Assigment.AulaCube.services;

import com.Abdul.Assigment.AulaCube.dtos.EmployeeDto;

import java.util.List;

public interface EmployeeService
{
    EmployeeDto AddEmployee(EmployeeDto employeeDto);// to Add emp in the db
    EmployeeDto getEmployeeById(Long empId); // to get emp by Id
    EmployeeDto updateEmployeeById(EmployeeDto employeeDto,Long empId); // to update emp by Id
    List<EmployeeDto> getListOfEmployees(); // to get all the list of employees
    public void deleteEmpById(Long empId); // to delete emp By Id

}
