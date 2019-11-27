package com.entity;

/**
 * @author cj
 * @date 2019/10/8
 */
public class Test {
    private String id;
    private String testname;
    private Integer xxx;
    private String yyy;

    public Integer getXxx() {
        return xxx;
    }

    public void setXxx(Integer xxx) {
        this.xxx = xxx;
    }

    public String getYyy() {
        return yyy;
    }

    public void setYyy(String yyy) {
        this.yyy = yyy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTestname() {
        return testname;
    }

    public void setTestname(String testname) {
        this.testname = testname;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id='" + id + '\'' +
                ", testname='" + testname + '\'' +
                ", xxx=" + xxx +
                ", yyy='" + yyy + '\'' +
                '}';
    }
}
