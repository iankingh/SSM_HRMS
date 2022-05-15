package com.hrms.service;

import com.hrms.mapper.DepartmentMapper;
import com.hrms.model.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ian
 */
@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    /**
     *  删除部門
     * @param deptId
     * @return
     */
    public int deleteDeptById(Integer deptId) {
        return departmentMapper.deleteDeptById(deptId);
    }

    /**
     * 修改部門
     * @param deptId
     * @param department
     * @return
     */
    public int updateDeptById(Integer deptId, Department department) {
        return departmentMapper.updateDeptById(deptId, department);
    }

    /**
     * 新增部門
     * @param department
     * @return
     */
    public int addDept(Department department) {
        return departmentMapper.insertDept(department);
    }

    /**
     * 查询部門
     * @return
     */
    public int getDeptCount() {
        return departmentMapper.countDepts();
    }

    /**
     * 查询部門
     * @param offset
     * @param limit
     * @return
     */
    public List<Department> getDeptList(Integer offset, Integer limit) {
        return departmentMapper.selectDeptsByLimitAndOffset(offset, limit);
    };

    public Department getDeptById(Integer deptId) {
        return departmentMapper.selectOneById(deptId);
    }

    public Department getDeptByName(String deptName) {
        return departmentMapper.selectOneByName(deptName);
    }

    public List<Department> getDeptName() {
        return departmentMapper.selectDeptList();
    }

}
