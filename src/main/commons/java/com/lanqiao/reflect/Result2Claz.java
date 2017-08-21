package com.lanqiao.reflect;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class Result2Claz {
public List SetData(String sql,Class claz,Object...orgs) throws SQLException{
    GetResult gr=new GetResult();
    ResultSet rs=gr.result2Claz(sql,claz,orgs);
    Object object = null;
    List list=new ArrayList<>();
//    try {
//        rsd = rs.getMetaData();
//        int columnCount=rsd.getColumnCount();
//    } catch (SQLException e) {
//        // TODO Auto-generated catch block
//        e.printStackTrace();
//    }
  
    try {
       
        
       List<Map> l=getResultMap(rs);
        for (Map map : l) {
            object=claz.newInstance();
        BeanUtils.populate(object, map);
        list.add(object);
        }
    } catch (IllegalAccessException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (InvocationTargetException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (InstantiationException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return list;
}
private static List<Map> getResultMap(ResultSet rs) throws SQLException  
         {  
    Map<String, String> hm ;  
    List<Map> list=new ArrayList<Map>();
    ResultSetMetaData rsmd = rs.getMetaData();  
    int count = rsmd.getColumnCount(); 
    while(rs.next()){
        hm = new HashMap<String, String>(); 
    for (int i = 1; i <= count; i++) {  
        String key = rsmd.getColumnName(i);  
        String value = rs.getString(i);  
        //System.out.println(value);
        hm.put(key, value);  
      
    }  
    list.add(hm);
    }
    return list;
} 
//    List list=new ArrayList<>();
//    
//    ResultSet rs=gr.result2Claz(sql, orgs);
    
}
