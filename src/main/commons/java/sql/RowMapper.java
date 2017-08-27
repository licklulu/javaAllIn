package sql;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {

    /**
     * 将指定的结果集转换为实体对象,用户需实现此接口提供具体的转换算法
     * @param rs 结果集
     * @return 实体对象
     * @throws SQLException
     */
    public abstract T mapRow(ResultSet rs) throws SQLException;

}
