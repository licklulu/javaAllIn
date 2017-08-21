package JDBCImprove;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;


public class JDBCFacadeImplTest {

    @Test
    public void ExquteQuerytest() {
        String sql="select * from userinfo "
                + "where nickname=?";
      ResultSet rs=JDBCFacadeImpl.me.ExquteQuery(sql,"白浩");
    try {
        while(rs.next()){
            System.out.println("已执行");
        }
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }

}
