package com.dao;

import com.entity.Dept;

import java.util.List;

/**
 * @author cj
 * @date 2019/10/10
 */
public interface DeptDao {
    void insertSimple(List<Dept> depts);

    void deleteSimple(List<Integer> ids);

    void updateSimple(List<Dept> depts);

    void update(Dept dept);
}
