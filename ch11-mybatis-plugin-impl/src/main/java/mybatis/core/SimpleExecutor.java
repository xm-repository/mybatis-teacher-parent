package mybatis.core;

/**
 * @author cj
 * @date 2019/10/14
 */
public class SimpleExecutor implements  Executor {
    @Override
    public void update() {
        System.out.println("update in SimpleExecutor----");
    }
}
