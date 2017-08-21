package JDBCImprove;

import java.sql.ResultSet;

public interface JDBCFacade {
public ResultSet ExquteQuery(String sql,Object...args);
public boolean ExquteUpdate(String sql);
}
