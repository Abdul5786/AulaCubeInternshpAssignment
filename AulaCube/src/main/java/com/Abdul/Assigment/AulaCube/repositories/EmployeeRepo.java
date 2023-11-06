package com.Abdul.Assigment.AulaCube.repositories;
import com.Abdul.Assigment.AulaCube.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employees,Long>
{
    // custom query
}
