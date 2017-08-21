package JDBCImprove;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.rowset.CachedRowSetImpl;

public enum JDBCFacadeImpl implements JDBCFacade{
me;
    final BlockingQueue<Connection> connsQueue=new LinkedBlockingDeque<>(10);
private JDBCFacadeImpl(){
    init();
}
/**
 * 连接池，可以连接10个
 */
private void init() {
    for (int i = 0; i < 10; i++) {
        try {
            connsQueue.add(createConn());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
@Override
public ResultSet ExquteQuery(String sql,Object...args) {
    Connection conn=null;
    Logger logger=LoggerFactory.getLogger(JDBCFacadeImpl.class);
   // try(Connection conn=createConn();Statement state=conn.createStatement();ResultSet rs=state.executeQuery(sql)){
       try{
            conn=getconn();
           PreparedStatement state=getPrepareStatement(conn,sql,args);
           ResultSet rs=state.executeQuery(); 
           return cahceRs(rs);
    } catch (SQLException e) {
        logger.error(e.getMessage(), e);
    }finally{
        release(conn);
    }
    return null;
}
@Override
public boolean ExquteUpdate(String sql) {
    Connection conn=null;
    Logger logger=LoggerFactory.getLogger(JDBCFacadeImpl.class);
   // try(Connection conn=createConn();Statement state=conn.createStatement();ResultSet rs=state.executeQuery(sql)){
       try{
            conn=getconn();
           PreparedStatement state=conn.prepareStatement(sql);
           if(state.execute()){
           return true;
           }
    } catch (SQLException e) {
        logger.error(e.getMessage(), e);
    }finally{
        release(conn);
    }
    return false;
}
/**
 * 将结果移入缓存中
 * @param rs
 * @return
 * @throws SQLException
 */
private ResultSet cahceRs(ResultSet rs) throws SQLException {
    com.sun.rowset.CachedRowSetImpl rowset=new CachedRowSetImpl();
    rowset.populate(rs);
    return rowset;
}
/**
 * 建立连接方法，返回连接
 * @return
 * @throws SQLException
 */
private Connection createConn() throws SQLException{
    
    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    Connection conn=DriverManager.getConnection
            (JdbcInterface.url,JdbcInterface.username,JdbcInterface.passwd);
    return conn;
}
/**
 * 从队列中取连接
 * @return
 */
public Connection getconn(){
    return  connsQueue.poll();
}
/**
 * 释放连接回连接池
 * @param conn
 */
private void release(Connection conn){
    try {
        if(conn!=null && !conn.isClosed()){
            connsQueue.add(conn);
        }
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    
}
private PreparedStatement getPrepareStatement(Connection conn,String sql,Object[] args) throws SQLException{
    PreparedStatement pstate=conn.prepareStatement(sql);
    for (int i = 0; i < args.length; i++) {
        pstate.setObject(i+1, args[i]);
    }
    return pstate;
}
}
