package JDBCConMysql;

public interface Config {
public String getDriverName();
public String getUrl();
public String getUser();
public String getPwd();
public int getMaxActive();
public int getMaxIde();
public long getMaxWait();
}
