/**
 *    Copyright 2009-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package v1.org.apache.ibatis.executor;


import org.apache.ibatis.executor.statement.StatementHandler;
import v1.org.apache.ibatis.mapping.MappedStatement;
import v1.org.apache.ibatis.session.Configuration;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Clinton Begin
 */
public class SimpleExecutor extends BaseExecutor {

  public SimpleExecutor(Configuration configuration) {
    super(configuration);
  }

  @Override
  public int doUpdate(MappedStatement ms, Object parameter) throws SQLException {
    Statement stmt = null;
    try {
      Configuration configuration = ms.getConfiguration();
      StatementHandler handler = configuration.newStatementHandler(this, ms, parameter, null, null, null);
      stmt = prepareStatement(handler);
      return handler.update(stmt);
    } finally {
      closeStatement(stmt);
    }
  }


  private Statement prepareStatement(StatementHandler handler) throws SQLException {
    Statement stmt;
    Connection connection = getConnection();
    stmt = handler.prepare(connection,null);
    handler.parameterize(stmt);
    return stmt;
  }

}
