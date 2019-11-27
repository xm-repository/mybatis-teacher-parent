package mybatis.core;

import mybatis.plugin.Interceptor;
import mybatis.plugin.InterceptorChain;

/**
 * @author cj
 * @date 2019/10/14
 */
public class Configuration {
    InterceptorChain chain = new InterceptorChain();
    public SqlSession getSqlSession(){
        SqlSession sqlSession = new DefaultSqlSession();
        //这行代码表示sqlSession这个组件是支持插件的,也就是说SqlSession的方法在执行的时候可以被拦截
        return (SqlSession) chain.pluginAll(sqlSession);
    }

    /**
     * 这个方法用来表示不支持拦截器的一些mybatis组件.
     * @return
     */
    public Executor getExecutor(){
        Executor executor =  new SimpleExecutor();
        //注释掉这行代码就表明Executor这个组件不支持拦截器机制
        //executor = (Executor) chain.pluginAll(executor);
        return  executor;
    }

    /**
     * 这个方法用来模拟读取mybatis-config文件的插件设置,添加到拦截器链中
     * @param interceptor
     */
    public void addInterceptor(Interceptor interceptor) {
        chain.addInterceptor(interceptor);
    }


}
