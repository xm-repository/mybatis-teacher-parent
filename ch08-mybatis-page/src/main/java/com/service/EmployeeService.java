package com.service;

import com.dao.EmployeeDao;
import com.entity.Employee;
import com.util.MapperFactory;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @author cj
 * @date 2019/10/12
 */
public class EmployeeService {

    private EmployeeDao dao = MapperFactory.generateMapper(EmployeeDao.class);


    public List<Employee> getEmpsByCustom(int pageNum, int pageSize){
        int offset= (pageNum-1)*pageSize;
        return dao.getEmpsByCustom(offset, pageSize);
    }

    public int getEmpsCount(){
        return dao.getEmpsCount();
    }



    public List<Employee> getEmpsByRowBounds(RowBounds rowBounds){
        return dao.getEmpsByRowBounds(rowBounds);
    }


    public List<Employee> getEmpsByPageHelper(int pageNum,int pageSize){
        return dao.getEmpsByPageHelper(pageNum, pageSize);
    }
}
