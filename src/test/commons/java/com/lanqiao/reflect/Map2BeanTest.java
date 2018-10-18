//package com.lanqiao.reflect;
//
//import static org.junit.Assert.*;
//
//import java.lang.reflect.InvocationTargetException;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.junit.Test;
//
//import compare.Student;
//
//public class Map2BeanTest {
//
//    @Test
//    public void test() {
//        Map<String,String> map=new HashMap<String,String>();
//       map.put("age","13");
//       map.put("age","12");
//        Map2Bean mb=new Map2Bean();
//        try {
//            System.out.println(mb.map2Bean(map, stuEntity.class));
//        } catch (IllegalAccessException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//
//}
