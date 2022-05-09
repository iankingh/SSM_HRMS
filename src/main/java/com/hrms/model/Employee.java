package com.hrms.model;

import lombok.Data;

@Data
public class Employee {
    private Integer empId;
    private String empName;
    private String empEmail;
    private String gender;
    private Integer departmentId;

    public Employee() {

    }

    public Employee(Integer empId, String empName, String empEmail, String gender, Integer departmentId) {
        this.empId = empId;
        this.empName = empName;
        this.empEmail = empEmail;
        this.gender = gender;
        this.departmentId = departmentId;
    }

}
