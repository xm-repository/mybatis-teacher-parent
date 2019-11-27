package com.entity;

import java.util.List;

/**
 * @author cj
 * @date 2019/9/26
 */
public class Dept {
    private Integer id;
    private String deptname;

    private Integer xxx;


    private List<Employee> employeeList;

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Integer getXxx() {
        return xxx;
    }

    public void setXxx(Integer xxx) {
        this.xxx = xxx;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }


    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", deptname='" + deptname + '\'' +
                ", xxx=" + xxx +
                ", employeeList=" + employeeList +
                '}';
    }
}
