package com.Abdul.Assigment.AulaCube.services.serviceImpl;

import com.Abdul.Assigment.AulaCube.dtos.DepartmentDtos;
import com.Abdul.Assigment.AulaCube.MongoEntites.Department;
import com.Abdul.Assigment.AulaCube.exceptionHandling.ResourceNotFoundException;
import com.Abdul.Assigment.AulaCube.repositories.MongoDbRepo.DepartmentRepo;
import com.Abdul.Assigment.AulaCube.services.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartMentServiceImpl  implements DepartmentService
{
    @Autowired
    private DepartmentRepo departmentRepo;
      @Autowired
      private ModelMapper modelMapper;
    @Override   // saving object
    public DepartmentDtos addDepartment(DepartmentDtos departmentDtos)
    {
        Department department = this.modelMapper.map(departmentDtos, Department.class);
        Department saved = departmentRepo.save(department);
        return this.modelMapper.map(saved,DepartmentDtos.class);
    }

    @Override
    public DepartmentDtos getDepartmentById(Long deptId) // geting object by id used proper exception if object not found
    {
        Department department = departmentRepo.findById(deptId)
                .orElseThrow(() -> new ResourceNotFoundException("department Id", "deptId", +deptId)); // exception thrown
        return this.modelMapper.map(department,DepartmentDtos.class);
    }

    @Override
    public List<DepartmentDtos> getListOfDepartment()
    {
        List<Department> listOfDepartment = departmentRepo.findAll(); // getting list and converting them into dtos one by one
        List<DepartmentDtos> listDeptDtos = listOfDepartment.stream(). // using java 8 stream apis
                map(dept -> this.modelMapper.map(dept, DepartmentDtos.class)).collect(Collectors.toList());
         return listDeptDtos;
    }

    @Override
    public DepartmentDtos updateDepartmentById(DepartmentDtos departmentDtos, Long deptId)
    {
        Department department = departmentRepo.findById(deptId)  // updating object first eeting and then updateing
                .orElseThrow(() -> new ResourceNotFoundException("department Id", "deptId", +deptId));
       department.setDepartmentName(departmentDtos.getDepartmentName());
       department.setUpdatedDate( new Date());
        Department saved = departmentRepo.save(department);
        return this.modelMapper.map(saved,DepartmentDtos.class);
    }

    @Override
    public void deleteDepartmentById(Long deptId)
    {
      departmentRepo.deleteById(deptId);
    }
}
