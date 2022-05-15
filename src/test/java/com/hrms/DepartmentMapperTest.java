package com.hrms;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import com.hrms.mapper.DepartmentMapper;
import com.hrms.model.Department;

/**
 * @author ian
 */
@Slf4j
@SpringBootTest
public class DepartmentMapperTest {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Test
    public void insertDeptTest() {
        Department department = new Department(null, "Musk", "測試部");
        int res = departmentMapper.insertDept(department);
        log.debug("res {}", res);
    }

    @Test
    public void updateDeptTest() {
        Department department = new Department(null, "ian05", "研發部");
        int res = departmentMapper.updateDeptById(1, department);
        log.debug("res {}", res);
    }

    @Test
    public void deleteDeptTest() {
        int res = departmentMapper.deleteDeptById(7);
        log.debug("res {}", res);
    }

    @Test
    public void selectOneByIdTest() {
        Department department = departmentMapper.selectOneById(1);
        log.debug("res {}", department);
    }

    @Test
    public void selectOneByLeaderTest() {
        
        Department department = departmentMapper.selectOneByLeader("Cook");
        log.debug("res {}", department);
    }

    @Test
    public void selectOneByNameTest() {
        Department department = departmentMapper.selectOneByName("CEO");
        log.debug("res {}", department);
    }

    @Test
    public void selectDeptListTest() {
        List<Department> departmentList = departmentMapper.selectDeptList();
        for (int i = 0; i < departmentList.size(); i++) {
            log.debug("res {}", departmentList.get(i));
        }
    }

    @Test
    public void selectDeptsByLimitAndOffsetTest() {
        List<Department> departments = departmentMapper.selectDeptsByLimitAndOffset(2, 5);
        log.debug("res {}", departments.size());
        for (int i = 0; i < departments.size(); i++) {
            log.debug("res {}", departments.get(i));
        }
    }

    @Test
    public void countDeptsTest() {
        int count = departmentMapper.countDepts();
        log.debug("res {}", count);
    }

}
