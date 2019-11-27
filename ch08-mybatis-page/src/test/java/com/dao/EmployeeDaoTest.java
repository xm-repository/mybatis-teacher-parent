package com.dao;

import com.entity.Employee;
import com.util.MapperFactory;
import org.junit.Test;

import java.util.List;

/**
 * @author cj
 * @date 2019/10/11
 */
public class EmployeeDaoTest {

    @Test
    public void testGetEmpsByCustom(){
        EmployeeDao dao = MapperFactory.generateMapper(EmployeeDao.class);
        int pageNum = 3;
        int pageSize = 3;
        int offset= (pageNum-1)*pageSize;
        List<Employee> emps = dao
                .getEmpsByCustom(offset, pageSize);


        for (Employee emp : emps) {
            System.out.println("-----debug: emp = " + emp);
        }
    }
}