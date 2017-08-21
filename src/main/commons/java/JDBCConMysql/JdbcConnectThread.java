package JDBCConMysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnectThread extends Thread{
    String sql=null;
    Statement s=null;
    Connection cnn=null;
    public void run(){
    
   
    try {
        sql="select * from userinfo where nickname='莫西西'";
        cnn=ConnectionFactory.getconn();
        cnn.setAutoCommit(false);
      
        //建立连接
       s =cnn.createStatement();
       s.executeQuery(sql);
       System.out.println("nh");
       
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }finally{
        if(cnn!=null){
            try {
                cnn.setAutoCommit(true);
                ConnectionFactory.back(cnn);
                cnn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
}
