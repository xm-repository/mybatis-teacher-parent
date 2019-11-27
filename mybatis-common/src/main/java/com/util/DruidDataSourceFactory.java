package com.util;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;

/**
 * @author cj
 * @date 2019/10/12
 */
public class DruidDataSourceFactory {
    public static DataSource getDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(ConnectionHelper.URL);
        druidDataSource.setUsername(ConnectionHelper.USERNAME);
        druidDataSource.setPassword(ConnectionHelper.PASSWORD);
        return druidDataSource;
    }
}
