package com.hrms.mapper;

import java.util.List;

import com.hrms.model.Department;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author ian
 * @since 1.0.0
 */
@Mapper
public interface DepartmentMapper {

        String TABLE_NAME = "tbl_dept";
        String INSERT_FIELDS = "dept_name, dept_leader";
        String SELECT_FIELDS = "dept_id as 'deptId', " +
                        "dept_name as 'deptName', " +
                        "dept_leader as 'deptLeader'";

        /**
         * 删除部門
         * 
         * @param deptId
         * @return
         */
        @Delete({ "DELETE FROM", TABLE_NAME, "WHERE dept_id=#{deptId}" })
        int deleteDeptById(@Param("deptId") Integer deptId);

        /**
         * 修改部門
         * 
         * @param deptId
         * @param department
         * @return
         */
        int updateDeptById(@Param("deptId") Integer deptId,
                        @Param("department") Department department);

        /**
         * 新增部門
         * 
         * @param department
         * @return
         */
        @Insert({ "INSERT INTO", TABLE_NAME, "(", INSERT_FIELDS, ") " +
                        "VALUES(#{department.deptName}, #{department.deptLeader})" })
        int insertDept(@Param("department") Department department);

        /**
         * =================================查询============================================
         */
        @Select({ "SELECT", SELECT_FIELDS, "FROM", TABLE_NAME, "WHERE dept_id=#{deptId}" })
        Department selectOneById(@Param("deptId") Integer deptId);

        @Select({ "SELECT", SELECT_FIELDS, "FROM", TABLE_NAME, "WHERE dept_leader=#{deptLeader}" })
        Department selectOneByLeader(@Param("deptLeader") String deptLeader);

        @Select({ "SELECT", SELECT_FIELDS, "FROM", TABLE_NAME, "WHERE dept_name=#{deptName}" })
        Department selectOneByName(@Param("deptName") String deptName);

        @Select({ "SELECT", SELECT_FIELDS, "FROM", TABLE_NAME })
        List<Department> selectDeptList();

        List<Department> selectDeptsByLimitAndOffset(@Param("offset") Integer offset,
                        @Param("limit") Integer limit);

        @Select({ "SELECT COUNT(dept_id) FROM", TABLE_NAME,
                        "WHERE deptLeader = #{deptLeader} OR deptName = #{deptName}" })
        int checkDeptsExistsByNameAndleader(@Param("deptLeader") String deptLeader,
                        @Param("deptName") String deptName);

        @Select({ "SELECT C?OUNT(*) FROM", TABLE_NAME })
        int countDepts();

}
