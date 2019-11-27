package com.nf.minimybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

/**
 * @author cj
 * @date 2019/10/9
 */
public class V0Test {



    @Test
    public void testMybatisApi() throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
        try(SqlSession session = factory.openSession(true)){
            session.insert("myinsert");

        }
    }
}
