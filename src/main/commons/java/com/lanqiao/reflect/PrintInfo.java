package com.lanqiao.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

import com.google.common.reflect.Invokable;

public class PrintInfo {
public static void main(String[] args) {
    StringBuilder str;
    Class<String> claz =String.class;
    Field[] fields=claz.getDeclaredFields();
    
//    TypeVariable<?>[] typeparms = claz.getTypeParameters();
    System.out.println("--------------域成员---------------");
 for (int i = 0; i < fields.length; i++) {
     str=new StringBuilder("");
    str.append(Modifier.toString(fields[i].getModifiers())+" "+fields[i].getType()+" "+fields[i].getName());
    System.out.println(str);
}

@SuppressWarnings("rawtypes") 
Constructor[] construtors=claz.getDeclaredConstructors();
System.out.println("-----------------构造方法名--------------");
for (int i = 0; i < construtors.length; i++) {
    str=new StringBuilder("");
    str.append(Modifier.toString(construtors[i].getModifiers())+" "+construtors[i].getName()+" ");
    Type[] typeparms=construtors[i].getParameterTypes();
    boolean first = true;
    
   
    for(Type typeparm: typeparms) {
        str.append('(');
        if (!first)
            str.append(',');
        str.append(typeparm.getTypeName());
        first = false;
    str.append(')');
    
}
System.out.println(str);
}
Method[] methods=claz.getDeclaredMethods(); 

System.out.println("-----------------方法名-----------------");
for (int i = 0; i < methods.length; i++) {
    
    str=new StringBuilder("");
    str.append(Modifier.toString(methods[i].getModifiers())
            +" "+methods[i].getReturnType()
            +" "+methods[i].getName()+" ");
   
   Type[] typeparms=methods[i].getParameterTypes();
        boolean first = true;
        
       
        for(Type typeparm: typeparms) {
            str.append('(');
            if (!first)
                str.append(',');
            str.append(typeparm.getTypeName());
            first = false;
        str.append(')');
        
    }
    System.out.println(str);
//    System.out.print(Modifier.toString(methods[i].getModifiers())+" ");
//    System.out.print(methods[i].getReturnType()+" ");
//    
}
}
}