package com.service;

import com.dao.DeptDao;
import com.entity.Dept;
import com.util.MapperFactory;

/**
 * @author cj
 * @date 2019/9/27
 */
public class DeptService {

    private DeptDao dao = MapperFactory.generateMapper(DeptDao.class );

    public Dept getById(){
        return dao.getById();
    }
}
