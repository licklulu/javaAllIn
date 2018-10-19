package designpatterns.proxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * @Auther: licklulu
 * @Description:
 * @Date: 2018/10/19 16:53
 */
public class TestCglibProxy {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ClassroomOption.class);//ClassroomOption为被继承的类
        enhancer.setCallback(new CglibProxy());
        ClassroomOption classroomOption = (ClassroomOption)enhancer.create();//生成代理类对象
        classroomOption.addClassroom("测试Cglib动态代理");
    }
}
