package com.lanqiao.reflect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import javax.sql.PooledConnection;

public class ConnectionFactory implements JdbcInterface{
    private static Vector<Connection> pool;
    private static int poolsize=1;
    static{
       
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
//            Class.forName(driver);
        pool=new Vector<>(poolsize);
        for (int i = 0; i < poolsize; i++) {
            try {
                Connection c =DriverManager.getConnection(url, username, passwd);
                pool.add(c);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 
            
        }
       
        
    }
    public static Connection getconn(){
        if(pool.size()<=0){
            try {
                pool.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    return pool.remove(0);
}
    public static void back(Connection c){
        synchronized (pool) {
         pool.notify();
         pool.add(c);
        }
    }
}

