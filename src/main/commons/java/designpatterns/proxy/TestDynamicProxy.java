package designpatterns.proxy;

import java.lang.reflect.Proxy;

/**
 * @Auther: licklulu
 * @Description:only satisfy interfaces
 * @Date: 2018/10/18 18:48
 */
public class TestDynamicProxy {
    public static void main(String[] args) {
        IClassroomOption classroomOption = new ClassroomOption();
        IClassroomOption iClassroomOptionProxy = (IClassroomOption) Proxy.newProxyInstance(IClassroomOption.class.getClassLoader(), new Class[]{IClassroomOption.class}, new DynamicProxy(classroomOption));
        iClassroomOptionProxy.addClassroom("测试jdk动态代理");
    }
}
