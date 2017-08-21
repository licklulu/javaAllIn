package com.lanqiao.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.reflect.Invokable;

public class Map2Bean {
public static<T> T map2Bean(Map<String,String> map,Class<T> claz) throws IllegalAccessException, InvocationTargetException, InstantiationException {
    Object object=claz.newInstance();
    Logger LOGGER=LoggerFactory.getLogger(Map2Bean.class);
//BeanUtils.populate(object, map);
for (Entry<String,String> entry : map.entrySet()) {
    String key=entry.getKey();
    String value=entry.getValue();
    
    String method="set"+upperFirstChar(key);
    Field f = null;
    try {
        f = claz.getDeclaredField("name");
    } catch (NoSuchFieldException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    } catch (SecurityException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }
    f.setAccessible(true);
    f.set(object, value);
 Invokable invokable = null;
try {
//    invokable = Invokable.from(claz.getDeclaredMethod(method, String.class));
    invokable = Invokable.from(claz.getDeclaredMethod(method, int.class));
} catch (NoSuchMethodException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} catch (SecurityException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
 invokable.invoke(object, value);
//    Field field = null ;
//    try {
//        field=claz.getDeclaredField(key);
//    } catch (NoSuchFieldException e1) {
//        // TODO Auto-generated catch block
//        e1.printStackTrace();
//    } catch (SecurityException e1) {
//        // TODO Auto-generated catch block
//        e1.printStackTrace();
//    }
//    Type fieldType=field.getType();
//    Method setter;
//    try {
//    switch (fieldType.getTypeName()) {
//    case "int":
//        setter=claz.getDeclaredMethod(method, int.class);
//      setter.invoke(object, Integer.parseInt(value));
//        break;
//    case "String":
//        setter=claz.getDeclaredMethod(method, String.class);
//        setter.invoke(key, value);
//        break;
//    case "float":
//        
//            setter=claz.getDeclaredMethod(method, float.class);
//        
//        setter.invoke(key, Float.valueOf(value));
//        break;
//    default:
//       
//       
//        
//    }
//    } catch (NoSuchMethodException e) {
//        LOGGER.error("没有这个方法"+e.getMessage());
//        continue;
//    } catch (SecurityException e) {
//        LOGGER.error("不安全");
//        continue;
//    }
}

    return (T) object;

}


private static String upperFirstChar(String key) {
    StringBuilder str=new StringBuilder((""+key.charAt(0)).toUpperCase());
    str.append(key.substring(1));
    return str.toString();
}
}