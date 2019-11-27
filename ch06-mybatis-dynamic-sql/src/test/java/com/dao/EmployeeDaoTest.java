package com.dao;

import com.entity.Employee;
import com.util.MapperFactory;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cj
 * @date 2019/10/9
 */
public class EmployeeDaoTest {

    @Test
    public void testGetEmpsBySalaryAndGender() {
        EmployeeDao employeeDao = MapperFactory.generateMapper(EmployeeDao.class);

       List<Employee> emps =  employeeDao
               .getEmpsBySalaryAndGender(BigDecimal.valueOf(2500), 1);
        for (Employee emp : emps) {
            System.out.println("-----debug: emp = " + emp);
        }

    }


    @Test
    public void testGetEmpsBySalaryAndGender2() {
        EmployeeDao employeeDao = MapperFactory.generateMapper(EmployeeDao.class);

        List<Employee> emps =  employeeDao.getEmpsBySalaryAndGender(null, null);
        for (Employee emp : emps) {
            System.out.println("-----debug: emp = " + emp);
        }

    }
    @Test
    public void testGetEmpsBySalaryAndGender3() {
        EmployeeDao employeeDao = MapperFactory.generateMapper(EmployeeDao.class);

        List<Employee> emps =  employeeDao.getEmpsBySalaryAndGender(null, 1);
        for (Employee emp : emps) {
            System.out.println("-----debug: emp = " + emp);
        }

    }
    @Test
    public void testGetEmpsBySalaryAndGender4() {
        EmployeeDao employeeDao = MapperFactory.generateMapper(EmployeeDao.class);

        List<Employee> emps =  employeeDao.getEmpsBySalaryAndGender(BigDecimal.valueOf(2500), null);
        for (Employee emp : emps) {
            System.out.println("-----debug: emp = " + emp);
        }

    }



    @Test
    public void testGetEmpsByDepts() {
        EmployeeDao employeeDao = MapperFactory.generateMapper(EmployeeDao.class);

        List<Integer> deptids = new ArrayList<>();
        deptids.add(1);
        deptids.add(2);
        List<Employee> emps =  employeeDao
                .getEmpsByDepts(deptids);
        for (Employee emp : emps) {
            System.out.println("-----debug: emp = " + emp);
        }

    }


    @Test
    public void testGetEmpsByDeptsMap() {
        EmployeeDao employeeDao = MapperFactory.generateMapper(EmployeeDao.class);

        Map<String, Integer> map = new HashMap<>();
        map.put("a",1);
        map.put("b",2);

        List<Employee> emps =  employeeDao
                .getEmpsByDeptsMap(map);
        for (Employee emp : emps) {
            System.out.println("-----debug: emp = " + emp);
        }

    }


    @Test
    public void testUpdate() {
        EmployeeDao employeeDao = MapperFactory.generateMapper(EmployeeDao.class);

        Employee employee = new Employee(BigDecimal.valueOf(3333), "mybatis9");
        employeeDao
                .update(employee);

    }
}