package mybatis.plugin;

import mybatis.core.SqlSession;

import java.util.Properties;

/**
 * 此接口是实现自己的mybatis拦截器必须实现的接口
 */
public interface Interceptor {

    /**
     * 自己的拦截器被调用时所执行的方法.
     *
     * @param invocation: 这个对象是一个封装,
     *                  里面包含被拦截对象(target),
     *                  被拦截对象的方法以及方法的参数值
     *
     * @return
     * @throws Throwable
     */
    Object intercept(Invocation invocation) throws Throwable;

    /**
     * 这个方法表明自己的拦截器是否是某个目标(target
     * 对象的拦截器.
     *
     * @param target
     * @return
     */
    default Object plugin(Object target) {
        if (target instanceof SqlSession) {
            return Plugin.wrap(target, this);
        }
        return target;
    }

    /**
     * 插件的一些属性设置,例如pageHelper插件的
     * supportMethodArguments属性值
     * @param properties
     */
    default void setProperties(Properties properties) {
        // NOP
    }

}