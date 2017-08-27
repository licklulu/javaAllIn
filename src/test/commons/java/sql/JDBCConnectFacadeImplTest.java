package sql;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class JDBCConnectFacadeImplTest {

    @Test
    public void test() {
        String sql="select name from people where id=?";
        JDBCConnectFacade connectFacde=JDBCConnectFacadeImpl.of(DataSourceType.SIMPLE);
       ResultSet rs= connectFacde.queryForResultSet(sql, 1);
     
    assertNotNull(rs);
    }

}
