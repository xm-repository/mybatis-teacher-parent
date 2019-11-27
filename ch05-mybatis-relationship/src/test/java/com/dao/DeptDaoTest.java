package com.dao;

import com.entity.Dept;
import com.util.MapperFactory;
import org.junit.Test;

/**
 * @author cj
 * @date 2019/10/9
 */
public class DeptDaoTest {

    @Test
    public void getDeptById() {

        DeptDao deptDao = MapperFactory.generateMapper(DeptDao.class);

        Dept dept = deptDao.getDeptById(1);

        System.out.println("-----debug: dept = " + dept);
    }
}