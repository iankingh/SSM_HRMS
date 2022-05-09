package com.hrms.model;

import lombok.Data;

/**
 *  
 */
@Data
public class Department {
    private Integer deptId;
    private String deptLeader;
    private String deptName;

    public Department() {
    }

    public Department(Integer deptId, String deptLeader, String deptName) {
        this.deptId = deptId;
        this.deptLeader = deptLeader;
        this.deptName = deptName;
    }


}
