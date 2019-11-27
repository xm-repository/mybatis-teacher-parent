package com;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author cj
 * @date 2019/9/26
 */
public class BasicCRUDTest {

    @Test
    public void testInsertShortName() throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
        try(SqlSession session = factory.openSession(true)){
            session.insert("myinsert");

        }
    }

    @Test
    public void testInsertLongName() throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
        try(SqlSession session = factory.openSession(true)){
            session.insert("myns.myinsert");
        }
    }


    @Test
    public void testUpdate() throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
        try(SqlSession session = factory.openSession(true)){
            session.insert("update");
        }
    }

    @Test
    public void testDelete() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
        try(SqlSession session = factory.openSession(true)){
            session.insert("delete");
        }
    }


    @Test
    public void testGetById() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
        try(SqlSession session = factory.openSession(true)){
           Dept dept =  session.selectOne("getById");
            System.out.println(dept);
        }
    }

    @Test
    public void testGetAll() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
        try(SqlSession session = factory.openSession(true)){
            List<Dept> depts =  session.selectList("getAll");
            for (Dept dept : depts) {
                System.out.println("-----debug: dept = " + dept);
            }
        }
    }


}
