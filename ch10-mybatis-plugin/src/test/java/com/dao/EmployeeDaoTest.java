package com.dao;

import com.entity.Employee;
import com.util.MapperFactory;
import org.junit.Test;

/**
 * @author cj
 * @date 2019/10/14
 */
public class EmployeeDaoTest {

    @Test
    public void getEmpById() {

        EmployeeDao dao = MapperFactory.generateMapper(EmployeeDao.class);
        Employee emp = dao.getEmpById(1);
        System.out.println("-----debug: emp = " + emp);
    }


}