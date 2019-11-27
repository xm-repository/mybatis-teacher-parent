package com.service;

import com.entity.Dept;
import org.junit.Test;

/**
 * @author cj
 * @date 2019/9/27
 */
public class DeptServiceTest {

    @Test
    public void getById() {
        Dept d= new DeptService().getById();
        System.out.println("-----debug: d = " + d);
    }
}