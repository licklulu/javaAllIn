package designpatterns.factory_builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Auther: lick
 * @Description:
 * @Date:2018/10/22 23:14
 */
public class TestReflect {
    private static final Logger logger = LoggerFactory.getLogger(TestReflect.class);
    public static void main(String[] args) {
        Class claz = null;
        try {
            claz = Class.forName("designpatterns.factory_builder.HuaweiFactory");
            Method method = claz.getDeclaredMethod("getTV", null);//parameterTypes is parameter of the method,such as String.calss,int.class
            Object object = claz.newInstance();
            TV tv = (TV) method.invoke(object, null);//object is new instance,args is parameter array
            tv.play();
        }catch (ClassNotFoundException c){
            logger.error("class not found", TestReflect.class.getSimpleName());
        }catch (IllegalAccessException i){
            logger.error("can not access");
        }catch (InstantiationException i){
            logger.error("can not get instance", i.getMessage());
        }catch (NoSuchMethodException n){
            logger.error("no such method", n.getMessage());
        }catch (InvocationTargetException i){
            logger.error("invocate error", i.getMessage());
        }

    }
}
