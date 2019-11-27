package com.dao;

import com.entity.Dept;
import org.apache.ibatis.annotations.Select;

/**
 * @author cj
 * @date 2019/9/27
 */
public interface DeptDao {
    @Select({"select id,deptname from dept where id = 2"})
    Dept getById();
}
