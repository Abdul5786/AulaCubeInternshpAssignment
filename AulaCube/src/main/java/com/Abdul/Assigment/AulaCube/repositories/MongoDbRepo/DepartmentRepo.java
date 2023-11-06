package com.Abdul.Assigment.AulaCube.repositories.MongoDbRepo;

import com.Abdul.Assigment.AulaCube.MongoEntites.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends MongoRepository<Department,Long>
{
}
