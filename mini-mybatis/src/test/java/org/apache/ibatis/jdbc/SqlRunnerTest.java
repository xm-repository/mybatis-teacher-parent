package org.apache.ibatis.jdbc;

import com.util.ConnectionHelper;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

/**
 * @author cj
 * @date 2019/10/12
 */
public class SqlRunnerTest {


    @Test
    public void testSelectOne() throws SQLException {
        Connection connection = ConnectionHelper.getConnection();
        SqlRunner sqlRunner = new SqlRunner(connection);
        String sql = "select id from employee where id = ?";
        Map<String,Object> result = sqlRunner.selectOne(sql, 1);
        for (Map.Entry<String,Object> entry:
             result.entrySet()) {
            System.out.println("-----debug: entry.getKey() = " + entry.getKey());
            System.out.println("-----debug: entry.getValue() = " + entry.getValue());
        }
    }

}
