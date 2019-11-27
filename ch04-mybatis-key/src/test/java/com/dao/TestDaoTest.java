package com.dao;

import com.util.MapperFactory;
import org.junit.Test;

/**
 * @author cj
 * @date 2019/10/8
 */
public class TestDaoTest {

    @Test
    public void insert() {

        TestDao testDao = MapperFactory.generateMapper(TestDao.class);
        com.entity.Test test = new com.entity.Test();
        // test实体类的id不是自己设置的,而是来自于数据库的查询,所以不设置
        test.setTestname("mybatis2");
        testDao.insert(test);


    }


    @Test
    public void insert_keyColumn() {

        TestDao testDao = MapperFactory.generateMapper(TestDao.class);
        com.entity.Test test = new com.entity.Test();
        // test实体类的所有数据都不需要设置,主要目的是演示selectKey中keyColumn属性的作用

        testDao.insert(test);
        System.out.println("-----debug: test = " + test);

    }
}