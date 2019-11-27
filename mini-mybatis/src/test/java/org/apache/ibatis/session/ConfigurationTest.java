package org.apache.ibatis.session;

/**
 * @author cj
 * @date 2019/10/12
 */
public class ConfigurationTest {

   /* @Test
    public void testConfigurationWithoutXml(){
        DataSource dataSource =  DruidDataSourceFactory.getDataSource();
        TransactionFactory transactionFactory =
                new JdbcTransactionFactory();
        Environment environment =
                new Environment("dev", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(EmployeeMapper.class);

        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(configuration);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        employeeMapper.update();
        assertNotNull(sqlSessionFactory);

    }

    @Test
    public void testConfigurationWithoutXml2(){
        DataSource dataSource =  DruidDataSourceFactory.getDataSource();
        TransactionFactory transactionFactory =
                new JdbcTransactionFactory();
        Environment environment =
                new Environment("dev", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(EmployeeMapper.class);

        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(configuration);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
       // EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
       // employeeMapper.update();
        sqlSession.update("update");
        assertNotNull(sqlSessionFactory);

    }
    @Test
    public void testConfigurationWithXml(){
       SqlSessionFactory sessionFactory = SqlSessionFactoryUtil.getFactory();
        assertNotNull(sessionFactory);

    }*/
}

