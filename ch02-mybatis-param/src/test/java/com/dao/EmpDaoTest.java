package com.dao;

import com.entity.Employee;
import com.util.MapperFactory;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cj
 * @date 2019/9/27
 */
public class EmpDaoTest {

    @Test
    public void insert() {

        Employee employee = new Employee(BigDecimal.valueOf(1000), 1, "mybatis2", 1);
        EmpDao dao = MapperFactory.generateMapper(EmpDao.class);
        dao.insert(employee);
    }


    @Test
    public void testGetById() {

        EmpDao dao = MapperFactory.generateMapper(EmpDao.class);
        Employee employee = dao.getById(1);
        System.out.println(employee);
    }


    @Test
    public void testEmployeeBySalaryAndGender() {

        EmpDao dao = MapperFactory.generateMapper(EmpDao.class);
        Employee employee = dao.getBySalaryAndGender(BigDecimal.valueOf(5000), 0);
        System.out.println(employee);
    }


    @Test
    public void testEmployeeBySalaryAndGender2() {

        EmpDao dao = MapperFactory.generateMapper(EmpDao.class);
        Employee employee = dao.getBySalaryAndGender2(BigDecimal.valueOf(5000), 0);
        System.out.println(employee);
    }


    @Test
    public void testGetAllByCondition() {

        EmpDao dao = MapperFactory.generateMapper(EmpDao.class);

        Map<String,Object> map = new HashMap<>();
        map.put("gg", 0);
        map.put("ss", 1000);
        map.put("sortField", "gender");
        map.put("sortType", "desc");
        List<Employee> employees = dao.getAllByCondition(map);
        for (Employee employee : employees) {
            System.out.println("-----debug: employee = " + employee);
        }
    }
}