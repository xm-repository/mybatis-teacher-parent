package com.entity;

/**
 * @author cj
 * @date 2019/10/12
 */
public class Pagination {
    private int pageSize = 2;
    private int pageNum = 1;
    private int count = 0;
    public Pagination(){}


    ////

    /**
     *
     * @param pageNum:当前页码:从1开始
     * @param count:记录的总数
     * @param pageSize:每页记录数
     */
    public Pagination(int pageNum,int count,int pageSize){
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.count = count;
    }

    public int getFirst(){
        return 1;
    }

    /**
     * 得到总页数
     * @return
     */
    public int getPageCount(){
       return  (int)Math.ceil(this.count*1.0/this.pageSize);
    }
    public int getLast(){
        return getPageCount();
    }

    public int getPrev(){
        return Math.max(this.pageNum-1,1);
    }

    public int getNext(){
        return Math.min(this.pageNum + 1,getPageCount());
    }
}
