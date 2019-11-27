package myplugin;

import mybatis.core.SqlSession;
import mybatis.plugin.*;

import java.util.Properties;

/**
 * @author cj
 * @date 2019/10/14
 */

@Intercepts({
        @Signature(type= SqlSession.class,
                method = "update",
        args = {})

      /*  ,@Signature(type= SqlSession.class,
                method = "query",
                args = {})*/
})
public class MyInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("****before****");
        Object result =  invocation.proceed();
        System.out.println("****after****");
        return result;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
