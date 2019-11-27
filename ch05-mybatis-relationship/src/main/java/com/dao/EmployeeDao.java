package com.dao;

import com.entity.Employee;

import java.util.List;

/**
 * @author cj
 * @date 2019/10/9
 */
public interface EmployeeDao {
    /**
     * 依据主键值查询一条员工记录以及关联的部门信息
     * @param id
     * @return
     */
   Employee getEmpById(int id);

    /**
     * 查询所有的员工以及每个员工关联对的部门信息
     * 主要用来演示n+1 查询的情况
     * @return
     */
   List<Employee> getEmps();
}
