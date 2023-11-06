package com.Abdul.Assigment.AulaCube.MongoEntites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("department")
public class Department
{
    @Id
    private Long departmentId;
    private String departmentName;
    private Date createDate;
    private Date updatedDate;

}
