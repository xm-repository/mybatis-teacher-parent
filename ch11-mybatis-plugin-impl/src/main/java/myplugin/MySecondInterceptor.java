package myplugin;

import mybatis.core.Executor;
import mybatis.plugin.*;

import java.util.Properties;

/**
 * @author cj
 * @date 2019/10/14
 */

@Intercepts({
        @Signature(type= Executor.class,
                method = "update",
        args = {})
})
public class MySecondInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("****before 2****");
        Object result =  invocation.proceed();
        System.out.println("****after 2****");
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
