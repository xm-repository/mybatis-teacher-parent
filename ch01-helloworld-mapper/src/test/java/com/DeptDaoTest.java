package com;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

/**
 * @author cj
 * @date 2019/9/26
 */
public class DeptDaoTest {

    @Test
    public void testGetById() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);

        try(SqlSession session = factory.openSession()){
            //getMapper的方式是利用动态代理技术,帮我们把DeptDao
            //这个接口生成一个实现类,它会找对应的mapper文件中的namespace + id
            //id是方法名确定
            DeptDao daoImpl = session.getMapper(DeptDao.class);
            Dept dept = daoImpl.getById();
            System.out.println(dept);
        }
    }


    @Test
    public void testUpdate() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);

        try(SqlSession session = factory.openSession()){

            DeptDao daoImpl = session.getMapper(DeptDao.class);
            daoImpl.update();
        }
    }
}
