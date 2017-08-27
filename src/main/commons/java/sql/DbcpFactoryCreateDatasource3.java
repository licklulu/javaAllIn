package sql;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDataSource;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
/*
 * 产生DataSource
 */
public  enum DbcpFactoryCreateDatasource3 {
me;
    public DataSource getDataSource(){
        String connectUrl=ConfigParseProperty2.getUrl();
        Properties prop=new Properties();
        prop.setProperty("name", ConfigParseProperty2.getUsername());
        prop.setProperty("password", ConfigParseProperty2.getPwd());
        return setDataSource(connectUrl,prop);
    }

    private DataSource setDataSource(String connectUrl, Properties prop) {
       ConnectionFactory connectionFactory =new DriverManagerConnectionFactory(connectUrl,prop);
       PoolableConnectionFactory poolableConnectionFactory=new PoolableConnectionFactory(connectionFactory,null);
       ObjectPool<PoolableConnection> connectionPool=new GenericObjectPool<>(poolableConnectionFactory);
       poolableConnectionFactory.setPool(connectionPool);
       PoolingDataSource<PoolableConnection> dataSource=new PoolingDataSource<>(connectionPool);
       System.out.println(dataSource); 
       return dataSource;
    }
}
