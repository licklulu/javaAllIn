package designpatterns.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Auther: lick
 * @Description:
 * @Date: 2018/10/18 19:21
 */
public class CglibProxy implements MethodInterceptor {
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before:" + method.getName());//调用方法之前做的事
        Object ob = methodProxy.invokeSuper(o, objects);
        int i=1;
        System.out.println("after:" + method.getName()+String.valueOf(i));//调用方法之后做的事
        return ob;
    }
}
