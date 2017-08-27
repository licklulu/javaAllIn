package sql;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * 解析jdbc1.properties
 * @author Administrator
 *
 */
public class ConfigParseProperty2 {
private static String driver;
private static String url;
private static String username;
private static String pwd;
private static int poolSize=1;
static{
    try {
    Properties props=new Properties();
//    ClassLoader classLoader=ConfigParseProperty2.class.getClassLoader();
    InputStream input=ConfigParseProperty2.class.getResourceAsStream("jdbc1.properties");
 
        props.load(input);
        driver=props.getProperty("driver");
        url=props.getProperty("url");
        username=props.getProperty("username");
        pwd=props.getProperty("passwd");
        poolSize=Integer.parseInt(props.getProperty("poolSize"));
    } catch (IOException e) {
        throw new RuntimeException(e.getMessage());
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
public static String getPwd() {
    return pwd;
}
public static int getPoolSize() {
    return poolSize;
}

}
