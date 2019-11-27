package com.util;

import org.apache.ibatis.session.SqlSession;

/**
 * @author cj
 * @date 2019/9/27
 */
public class MapperFactory {
    /**
     * 现在的这个写法,是有bug
     * 因为sqlSession没办法关闭,sqlSession是必须关闭的
     * @param clz
     * @param <T>
     * @return
     */
    public static <T> T generateMapper(Class<? extends  T> clz){
        SqlSession session = SqlSessionFactoryUtil.getSession();
        return session.getMapper(clz);
    }



}
