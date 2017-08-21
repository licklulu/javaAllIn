package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {
private Subject target;

    public ProxyHandler(Subject target) {
    super();
    this.target = target;
}

    @Override
    public Object invoke(Object proxy, Method method, 
            Object[] args) throws Throwable {
        //在转调具体对象支前，可以执行一些功能处理
        //转调具体对象的方法
        return method.invoke(target, args);
        //在转调具体对象之后，可以执行一些功能处理
    }

}
