package com.Abdul.Assigment.AulaCube.services.serviceImpl;

import com.Abdul.Assigment.AulaCube.dtos.EmployeeDto;
import com.Abdul.Assigment.AulaCube.entities.Employees;
import com.Abdul.Assigment.AulaCube.exceptionHandling.ResourceNotFoundException;

import com.Abdul.Assigment.AulaCube.repositories.EmployeeRepo;
import com.Abdul.Assigment.AulaCube.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService
{

    @Autowired
    private EmployeeRepo employeeRepo;


    @Autowired
    private ModelMapper modelMapper;
    @Override
    public EmployeeDto AddEmployee(EmployeeDto employeeDto)
    {
        Employees emp = this.modelMapper.map(employeeDto, Employees.class); // converting them to entities from dtos
        emp.setCreatedAt(new Date());
        Employees save = employeeRepo.save(emp);      // saving object
        return  this.modelMapper.map(save, EmployeeDto.class);
    }

    @Override
    public EmployeeDto getEmployeeById(Long empId)
    {
        Employees employees = employeeRepo.findById(empId)
                .orElseThrow(() -> new ResourceNotFoundException("employee Id", "empId", +empId)); // finding data using exception
            return  this.modelMapper.map(employees, EmployeeDto.class);
    }

    @Override
    public EmployeeDto updateEmployeeById(EmployeeDto employeeDto, Long empId)
    {
        Employees employees = employeeRepo.findById(empId)
                .orElseThrow(() -> new ResourceNotFoundException("employee Id", "empId", +empId));
          employees.setFirstName(employeeDto.getFirstName());
          employees.setLasName(employeeDto.getLasName());
          employees.setEmail(employeeDto.getEmail());
          employees.setDepartmentId(employeeDto.getDepartmentId());
          employees.setUpdatedAt(new Date());
          Employees updatedEmployee = employeeRepo.save(employees);
          return this.modelMapper.map(employees,EmployeeDto.class);
    }

    @Override   // fetchinh list of employees then coverting them into dtos one by one  java8 using stream apis
    public List<EmployeeDto> getListOfEmployees()
    {
        List<Employees> listOfEmployees = employeeRepo.findAll();
        List<EmployeeDto> listOfEmployeeDtos = listOfEmployees.stream().map(employees -> this.modelMapper.map(employees, EmployeeDto.class)).collect(Collectors.toList());
        return listOfEmployeeDtos;
    }

    @Override
    public void deleteEmpById(Long empId)
    {
        employeeRepo.deleteById(empId);
    }
}
