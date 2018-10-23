package designpatterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Auther: lick
 * @Description:
 * @Date: 2018/10/18 18:40
 */
public class DynamicProxy implements InvocationHandler {
    private Object object;
    public DynamicProxy(Object object){
        this.object = object;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(object, args);
        return result;
    }
}
