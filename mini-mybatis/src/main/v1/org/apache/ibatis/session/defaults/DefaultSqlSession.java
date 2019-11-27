/**
 * Copyright 2009-2019 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package v1.org.apache.ibatis.session.defaults;


import org.apache.ibatis.mapping.MappedStatement;
import v1.org.apache.ibatis.executor.Executor;
import v1.org.apache.ibatis.session.Configuration;
import v1.org.apache.ibatis.session.SqlSession;

/**
 * The default implementation for {@link SqlSession}.
 * Note that this class is not Thread-Safe.
 *
 * @author Clinton Begin
 */
public class DefaultSqlSession implements SqlSession {

    private final Configuration configuration;
    private final Executor executor;

    private final boolean autoCommit;
    private boolean dirty;


    public DefaultSqlSession(Configuration configuration, Executor executor, boolean autoCommit) {
        this.configuration = configuration;
        this.executor = executor;
        this.dirty = false;
        this.autoCommit = autoCommit;
    }


    @Override
    public int update(String statement) {
        try {
            dirty = true;
            MappedStatement ms = configuration.getMappedStatement(statement);
            return executor.update(ms, null);
        } catch (Exception e) {
            throw new RuntimeException("Error updating database.  Cause: " + e, e);
        } finally {

        }
    }



    @Override
    public void close() {
        try {
           // executor.close(false);
            dirty = false;
        } finally {

        }
    }


    @Override
    public Configuration getConfiguration() {
        return configuration;
    }


}
