package com.dao;

import com.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author cj
 * @date 2019/9/27
 */
public interface EmpDao {
    int insert(Employee employee);

    Employee getById(int id);

    Employee getBySalaryAndGender(BigDecimal salary,int gender);

    Employee getBySalaryAndGender2(@Param("s") BigDecimal salary, @Param("g") int gender);

    List<Employee> getAllByCondition(Map<String, Object> conditions);
}
