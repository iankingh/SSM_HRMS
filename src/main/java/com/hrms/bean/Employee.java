package com.hrms.bean;

import lombok.Data;

@Data
public class Employee {
    
    private Integer empId;
    private String empName;
    private String empEmail;
    private String gender;
    private Integer departmentId;
    
}
