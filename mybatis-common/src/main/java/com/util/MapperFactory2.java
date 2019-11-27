package com.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author cj
 * @date 2019/9/27
 */
public class MapperFactory2 {
    public static <T> T generateMapper(Class<? extends  T> clz){
        SqlSession session = SqlSessionFactoryUtil.getSession();
        T mapper =  session.getMapper(clz);
        InvocationHandler handler = new MapperInterceptor(session, mapper);
        return (T) Proxy.newProxyInstance(clz.getClassLoader(), new Class[]{clz}, handler);
    }


    private static class MapperInterceptor implements InvocationHandler{
        private SqlSession sqlSession;
        private Object target;
        public MapperInterceptor(SqlSession sqlSession,Object target) {
            this.sqlSession = sqlSession;
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            try {
                return method.invoke(target, args);
            }finally {
                System.out.println("close-----");
                sqlSession.close();
            }
        }
    }
}
