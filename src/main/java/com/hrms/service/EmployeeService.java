package com.hrms.service;

import java.util.List;

import com.hrms.mapper.EmployeeMapper;
import com.hrms.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author  ian 
 * @since 1.0.0
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    public int getEmpCount() {
        return employeeMapper.countEmps();
    }

    public List<Employee> getEmpList(Integer offser, Integer limit) {
        return employeeMapper.selectByLimitAndOffset(offser, limit);
    }

    public Employee getEmpById(Integer empId) {
        return employeeMapper.selectOneById(empId);
    }

    public Employee getEmpByName(String empName) {
        return employeeMapper.selectOneByName(empName);
    };

    public int updateEmpById(Integer empId, Employee employee) {
        return employeeMapper.updateOneById(empId, employee);
    }

    public int deleteEmpById(Integer empId) {
        return employeeMapper.deleteOneById(empId);
    }

    public int addEmp(Employee employee) {
        return employeeMapper.insertOne(employee);
    }

}
