package com.dao;

import com.entity.Employee;
import com.util.MapperFactory;
import org.junit.Test;

import java.util.List;

/**
 * @author cj
 * @date 2019/10/9
 */
public class EmployeeDaoTest {

    @Test
    public void getEmpById() {
        EmployeeDao employeeDao = MapperFactory.generateMapper(EmployeeDao.class);
        
       Employee employee =  employeeDao.getEmpById(3);
        System.out.println("-----debug: employee = " + employee);
    }


    @Test
    public void getEmps() {
        EmployeeDao employeeDao = MapperFactory.generateMapper(EmployeeDao.class);

        List<Employee> employees =  employeeDao.getEmps();

        for (Employee employee : employees) {
            System.out.println("-----debug: employee = " + employee);
        }
    }
}