package com.dao;

import com.entity.Dept;
import com.util.MapperFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cj
 * @date 2019/10/10
 */
public class DeptDaoTest {

    @Test
    public void testInsertSimple() {

        DeptDao dao = MapperFactory.generateMapper(DeptDao.class);

        List<Dept> depts = new ArrayList<>();
        for(int i=0;i<5;i++){
            Dept dept = new Dept();
            dept.setDeptname("from " + i);
            depts.add(dept);
        }
        dao.insertSimple(depts);
    }


    @Test
    public void testDeleteSimple() {

        DeptDao dao = MapperFactory.generateMapper(DeptDao.class);

        List<Integer> keys = new ArrayList<>();
        for(int i=17;i<22;i++){

            keys.add(i);
        }
        dao.deleteSimple(keys);
    }


    @Test
    public void testUpdateSimple() {

        DeptDao dao = MapperFactory.generateMapper(DeptDao.class);

        List<Dept> depts = new ArrayList<>();
        for(int i=11;i<16;i++){
            Dept dept = new Dept();
            dept.setId(i);
            dept.setDeptname("from " + i);
            depts.add(dept);
        }
        dao.updateSimple(depts);
    }
    @Test
    public void testUpdateBatch() {

    }

}