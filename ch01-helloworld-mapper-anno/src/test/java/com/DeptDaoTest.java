package com;

import com.dao.DeptDao;
import com.entity.Dept;
import com.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author cj
 * @date 2019/9/27
 */
public class DeptDaoTest {

    @Test
    public void getById() {

        SqlSession session = SqlSessionFactoryUtil.getSession();
        DeptDao deptDao = session.getMapper(DeptDao.class);
        Dept d = deptDao.getById();
        System.out.println("-----debug: d = " + d);
        session.close();
    }
}