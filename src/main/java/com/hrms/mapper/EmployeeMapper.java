package com.hrms.mapper;

import java.util.List;

import com.hrms.model.Employee;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author ian
 * @sine 1.0.0
 */
@Mapper
public interface EmployeeMapper {

    String TABLE_NAME = "tbl_emp";
    String INSERT_FIELDS = "emp_name, emp_email, gender, department_id";
    String SELECT_FIELDS = "emp_id, " + INSERT_FIELDS;

    /**
     * 刪除員工
     * 
     * @param empId
     * @return
     */
    @Delete({ "DELETE FROM", TABLE_NAME, "WHERE emp_id = #{empId}" })
    int deleteOneById(@Param("empId") Integer empId);

    /**
     * 修改員工
     * 
     * @param empId
     * @param employee
     * @return
     */
    int updateOneById(
            @Param("empId") Integer empId,
            @Param("employee") Employee employee);

    /**
     * 新增員工
     * 
     * @param employee
     * @return
     */
    @Insert({ "INSERT INTO", TABLE_NAME, "(", INSERT_FIELDS, ") " +
            "VALUES(#{empName}, " +
            "#{empEmail}, " +
            "#{gender}, " +
            "#{departmentId})" })
    int insertOne(Employee employee);

    /**
     * 查詢所有員工
     * 
     * @param empId
     * @return
     */
    Employee selectOneById(@Param("empId") Integer empId);

    /**
     * 查詢所有員工
     * 
     * @param empName
     * @return
     */
    Employee selectOneByName(@Param("empName") String empName);

    /**
     * 分頁查詢
     * 
     * @param limit  返回记录最大行数
     * @param offset 返回记录行的偏移量
     * @return 如offset=10，limit=5的时候，就会从数据库第11行记录开始返回5条查询结果，即范围从(offset+1)---(offset+limit)
     */
    List<Employee> selectByLimitAndOffset(@Param("offset") Integer offset,
            @Param("limit") Integer limit);

    /**
     * 查詢總記錄數
     * 
     * @return
     */
    @Select({ "select count(*) from", TABLE_NAME })
    int countEmps();

}
