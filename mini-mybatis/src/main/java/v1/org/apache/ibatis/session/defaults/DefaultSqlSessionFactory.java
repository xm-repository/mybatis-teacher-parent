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
package v1.org.apache.ibatis.session.defaults;


import v1.org.apache.ibatis.executor.Executor;
import v1.org.apache.ibatis.mapping.Environment;
import v1.org.apache.ibatis.session.Configuration;
import v1.org.apache.ibatis.session.ExecutorType;
import v1.org.apache.ibatis.session.SqlSession;
import v1.org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author Clinton Begin
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

  private final Configuration configuration;

  public DefaultSqlSessionFactory(Configuration configuration) {
    this.configuration = configuration;
  }



  @Override
  public SqlSession openSession(boolean autoCommit) {
    return openSessionFromDataSource(configuration.getDefaultExecutorType(),  autoCommit);
  }


  @Override
  public Configuration getConfiguration() {
    return configuration;
  }

  private SqlSession openSessionFromDataSource(ExecutorType execType, boolean autoCommit) {

    try {
      final Environment environment = configuration.getEnvironment();

      final Executor executor = configuration.newExecutor( execType);
      return new DefaultSqlSession(configuration, executor, autoCommit);
    } catch (Exception e) {

      throw new RuntimeException("Error opening session.  Cause: " + e, e);
    } finally {

    }
  }




}
