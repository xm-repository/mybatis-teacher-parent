package com.dao;

import com.entity.Dept;
import com.util.MapperFactory2;
import org.junit.Test;

/**
 * @author cj
 * @date 2019/10/8
 */
public class DeptDaoTest {

    @Test
    public void insert() {

        DeptDao deptDao = MapperFactory2.generateMapper(DeptDao.class);
        Dept dept = new Dept();
        // 主键是数据库生成,所以可以不用设置.
        dept.setDeptname("mybatis-");
        System.out.println("插入前的dept对象:" + dept);
        deptDao.insert(dept);
        System.out.println("-----debug: dept = " + dept);
    }
}