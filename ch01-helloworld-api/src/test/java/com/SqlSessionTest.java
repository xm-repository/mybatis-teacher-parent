package com;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author cj
 * @date 2019/9/26
 */
public class SqlSessionTest {

    @Test
    public void testSqlSession1() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        session.close();
        System.out.println(session);
    }

    @Test
    public void testSqlSession2() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = null;
        try{
             session = factory.openSession();

            System.out.println(session);
        }finally {
            session.close();
        }

    }

    @Test
    public void testSqlSession3() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
        //下面这种写法是jdk7才有的, 等价于try finally的写法
        // 推荐的写法,这种写法,括号里面的类型必须实现了closable接口
        try(SqlSession session = factory.openSession()){
            System.out.println(session);
        }


    }
}
