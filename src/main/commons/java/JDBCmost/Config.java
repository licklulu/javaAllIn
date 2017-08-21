package JDBCmost;

import java.util.Properties;

public class Config {
private static String driver;
private static String url;
private static String username;
private static String passwd;
private static int poolSize;
static{
    Properties pros=new Properties();
    driver=pros.getProperty("driver");
    url=pros.getProperty("url");
    username=pros.getProperty("username");
    passwd=pros.getProperty("passwd");
    poolSize=Integer.parseInt(pros.getProperty("poolSize"));
    if(poolSize<0){
        poolSize=10;
    }
}
public static String getDriver() {
    return driver;
}
public static String getUrl() {
    return url;
}
public static String getUsername() {
    return username;
}
public static String getPasswd() {
    return passwd;
}
public static int getPoolSize() {
    return poolSize;
}

}
