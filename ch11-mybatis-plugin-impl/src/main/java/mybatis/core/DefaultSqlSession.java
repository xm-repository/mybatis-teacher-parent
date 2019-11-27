package mybatis.core;

/**
 * @author cj
 * @date 2019/10/14
 */
public class DefaultSqlSession implements SqlSession{
    @Override
    public void update() {

        System.out.println("update in defaultSqlSession---");
    }

    @Override
    public void query() {
        System.out.println("query in DefaultSqlSession---");
    }
}
