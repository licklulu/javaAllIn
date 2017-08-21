package JDBCConMysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcIterfaceImpl  {

    @SuppressWarnings("resource")
    public void conn() {
        String sql=null;
        Statement s=null;
        ResultSet rs=null;
        Connection cnn=null;
       
        try {
            cnn.setAutoCommit(false);
            cnn=ConnectionFactory.getconn();
            //建立连接
           s =cnn.createStatement();
           rs=s.executeQuery(sql);
           
           
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
