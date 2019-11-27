package com.dao;

import com.entity.Employee;
import com.util.MapperFactory;
import org.junit.Test;

import java.util.List;

/**
 * @author cj
 * @date 2019/9/29
 */
public class EmpDaoTest {

    @Test
    public void getAll() {

        EmpDao dao = MapperFactory.generateMapper(EmpDao.class);
        List<Employee> employees = dao.getAll();
        for (Employee employee : employees) {
            System.out.println("-----debug: employee = " + employee);
        }
    }
}