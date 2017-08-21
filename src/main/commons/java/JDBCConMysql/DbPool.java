package JDBCConMysql;


import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
public interface DbPool {
    public Connection createConnection() throws SQLException;
    public DataSource getDataSource();
}

