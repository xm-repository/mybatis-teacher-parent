package com.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 编写MyBatis拦截器的步骤
 * 1. 编写一个类实现Interceptor接口
 *  1.1. 一般只需要实现intercept方法即可
 *  1.2 intercept方法的Invocation对象封装了如下信息
 *      1.2.1. 被拦截对象
 *      1.2.2   被拦截的方法
 *      1.2.3   被拦截方法执行时实际传递给方法的参数信息
 *  1.3 可选的实现plugin方法
 *  1.4 在此类上通过注解@Intercepts设定此拦截器到底拦截谁
 * 2.在mybatis-config文件中对你自己编写的拦截器(插件)进行配置,在plugins元素里进行配置
 * 3.使用mybatis的某个功能,此功能会导致你的拦截代码会得到执行
 *
 * 下面的拦截器设置会导致当执行mybatis的查询功能时,拦截器会拦截这个查询操作.
 * @author cj
 * @date 2019/10/14
 */
@Intercepts({
        @Signature(type = Executor.class,
                method = "query",
                args = {MappedStatement.class,Object.class, RowBounds.class, ResultHandler.class})
})
public class MyInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object target = invocation.getTarget();
        System.out.println("------debug: 被代理对象---" + target);
        Method method = invocation.getMethod();
        System.out.println("-----debug: 被代理方法 = " + method);
        Object[] args = invocation.getArgs();
        System.out.println("-----debug: 被代理方法参数:args = " + args);
        System.out.println("---方法拦截前执行代码块");

        Object result = invocation.proceed();
        System.out.println("-----方法拦截后执行代码块");

        return result;
    }

    /**
     * 这个方法可以不用实现,默认就是调用Plugin.wrap方法
     * @param target
     * @return
     */
    @Override
    public Object plugin(Object target) {
        if(target instanceof  Executor){
            return Plugin.wrap(target, this);
        }else{
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
