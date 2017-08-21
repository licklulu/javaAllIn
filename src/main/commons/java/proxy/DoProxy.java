package proxy;

import java.lang.reflect.InvocationHandler;
import java.util.ArrayList;
import java.util.List;

import com.google.common.reflect.Reflection;

public class DoProxy {
    
public static void main(String[] args) {
//    RealSubject real=new RealSubject();
//    Subject proxySubject=(Subject) Proxy.newProxyInstance
//            (Subject.class.getClassLoader(), new Class[]{Subject.class}, new ProxyHandler(real));
//            proxySubject.doSomething();
//            InvocationHandler handl;er = new DemoHandler();
//            Reflection.newProxy(Subject.class, handler);
            RealSubject rs=new RealSubject();
            InvocationHandler handler= new ProxyHandler(rs);  
  //          ClassLoader loader=Subject.class.getClassLoader();
           Subject proxyObject=Reflection.newProxy(Subject.class, handler);
          
  //                 (Subject)Proxy.newProxyInstance(loader, new Class[]{Subject.class}, handler);
           System.out.println(proxyObject.doSomething());
}


}
