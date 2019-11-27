package mybatis.plugin;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/** 每一个Interceptor实现类都是一个插件(Plugin)
 * 此类可以理解为对一个拦截器的描述.
 * 提供了2个核心功能:
 * 1.wrap方法表明拦截器要拦截谁
 * 2.表明拦截器执行时被调用的方法(invoke->intercept)
 * @author Clinton Begin
 */
public class Plugin implements InvocationHandler {

  private final Object target;
  private final Interceptor interceptor;
    /**
     * 此变量用来记录每个拦截器所拦截的所有mybatis组件方法
     */
  private final Map<Class<?>, Set<Method>> signatureMap;

  private Plugin(Object target, Interceptor interceptor, Map<Class<?>, Set<Method>> signatureMap) {
    this.target = target;
    this.interceptor = interceptor;
    this.signatureMap = signatureMap;
  }

    /**
     * 此方法用来确定是否对某个目标对象进行插件管理.
     * mybatis中不是所有的组件都支持插件功能的,只有部分组件
     * 支持插件功能
     *
     * 作用是用来给mybatis中一些有插件功能的组件生产动态代理.
     * @param target:mybatis中支持插件功能的组件
     * @param interceptor
     * @return
     */
  public static Object wrap(Object target, Interceptor interceptor) {
    Map<Class<?>, Set<Method>> signatureMap = getSignatureMap(interceptor);
    Class<?> type = target.getClass();
    Class<?>[] interfaces = getAllInterfaces(type, signatureMap);
    if (interfaces.length > 0) {
      return Proxy.newProxyInstance(
          type.getClassLoader(),
          interfaces,
          new Plugin(target, interceptor, signatureMap));
    }
    return target;
  }

    /**
     * mybatis核心组件的执行转到了这个方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    try {
      Set<Method> methods = signatureMap.get(method.getDeclaringClass());
     //检查当前执行的方法是否在
      if (methods != null && methods.contains(method)) {
        //mybatis核心功能的执行接着又转到了拦截器对象的intercept方法去执行
          //最后又交给Invocation对象的proceed方法去执行
          return interceptor.intercept(new Invocation(target, method, args));
      }
      return method.invoke(target, args);
    } catch (Exception e) {
        throw new RuntimeException("plugin method invoke failed");
    }
  }

    /**
     * 获取插件声明的,此声明表明是对mybatis组件的哪个方法进行拦截
     * @param interceptor
     * @return
     */
  private static Map<Class<?>, Set<Method>> getSignatureMap(Interceptor interceptor) {
    Intercepts interceptsAnnotation = interceptor.getClass().getAnnotation(Intercepts.class);
    // issue #251
    if (interceptsAnnotation == null) {
      throw new PluginException("No @Intercepts annotation was found in interceptor " + interceptor.getClass().getName());
    }
    Signature[] sigs = interceptsAnnotation.value();
    Map<Class<?>, Set<Method>> signatureMap = new HashMap<>();
    for (Signature sig : sigs) {
      Set<Method> methods = signatureMap.computeIfAbsent(sig.type(), k -> new HashSet<>());
      try {
        Method method = sig.type().getMethod(sig.method(), sig.args());
        methods.add(method);
      } catch (NoSuchMethodException e) {
        throw new PluginException("Could not find method on " + sig.type() + " named " + sig.method() + ". Cause: " + e, e);
      }
    }
    return signatureMap;
  }

  private static Class<?>[] getAllInterfaces(Class<?> type, Map<Class<?>, Set<Method>> signatureMap) {
    Set<Class<?>> interfaces = new HashSet<>();
    while (type != null) {
      for (Class<?> c : type.getInterfaces()) {
        if (signatureMap.containsKey(c)) {
          interfaces.add(c);
        }
      }
      type = type.getSuperclass();
    }
    return interfaces.toArray(new Class<?>[interfaces.size()]);
  }

}
