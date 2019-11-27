package com.dao;

import com.entity.Employee;

import java.util.List;

/**
 * @author cj
 * @date 2019/9/29
 */
public interface EmpDao {

    List<Employee> getAll();
}
