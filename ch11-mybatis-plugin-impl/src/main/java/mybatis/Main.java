package mybatis;

import mybatis.core.Configuration;
import mybatis.core.Executor;
import mybatis.core.SqlSession;
import myplugin.MyInterceptor;
import myplugin.MySecondInterceptor;

/**
 * @author cj
 * @date 2019/10/14
 */
public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.addInterceptor(new MyInterceptor());
        configuration.addInterceptor(new MySecondInterceptor());

        SqlSession sqlSession = configuration.getSqlSession();
        sqlSession.update();

        //调用了也不会执行拦截器的代码,因为拦截器没有设定要对SqlSession的query方法进行拦截
        sqlSession.query();
        Executor executor = configuration.getExecutor();
        executor.update();
    }
}
