//package com.lanqiao.reflect;
//
//import static org.junit.Assert.*;
//
//import java.sql.SQLException;
//import java.util.List;
//
//import org.junit.Test;
//
//public class Result2ClazTest {
//    List list;
//    @Test
//    public void test() {
//        String sql="select * from user limit ?";
//        Result2Claz rc=new Result2Claz();
//
//
//    try {
//        list = rc.SetData(sql, User.class,3);
//    } catch (SQLException e) {
//        // TODO Auto-generated catch block
//        e.printStackTrace();
//    }
//       System.out.println(list);
//    }
//
//}
