import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import JDBCConMysql.ConnectionFactory;
import JDBCConMysql.JdbcConnectThread;

public class JDBCConTest {
public static void main(String[] args) {
    String sql=null;
    Statement s=null;
    Connection cnn=null;
   
    try {
        sql="select * from userinfo where nickname='您好'";
        cnn=ConnectionFactory.getconn();
        cnn.setAutoCommit(false);
      new JdbcConnectThread().start();
        //建立连接
       s =cnn.createStatement();
       s.executeQuery(sql);
       
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
