package com.service;

import com.entity.Dept;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cj
 * @date 2019/10/11
 */
public class DeptServiceTest {

    @Test
    public void updateBatch() {
        List<Dept> depts = new ArrayList<>();
        for(int i=11;i<16;i++){
            Dept dept = new Dept();
            dept.setId(i);
            dept.setDeptname("to " + i);
            depts.add(dept);
        }

        DeptService deptService = new DeptService();

        deptService.updateBatch(depts);


    }


    @Test
    public void updateBatch2() {
        List<Dept> depts = new ArrayList<>();
        for(int i=11;i<16;i++){
            Dept dept = new Dept();
            dept.setId(i);
            dept.setDeptname("from " + i);
            depts.add(dept);
        }

        DeptService deptService = new DeptService();

        deptService.updateBatch2(depts);


    }
}