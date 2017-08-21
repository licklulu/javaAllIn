package com.lanqiao.reflect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetResult {
public ResultSet result2Claz(String sql,Class claz,Object...orgs){
    Logger logger=LoggerFactory.getLogger(GetResult.class);
    Connection conn=ConnectionFactory.getconn();
    PreparedStatement state = null;
    ResultSet rs = null;
    try {
        state = getPrepareStatement(conn,sql,orgs);
         rs=state.executeQuery();
    } catch (SQLException e1) {
       logger.error(e1.getMessage(),e1);
    } 
    return rs;
    
}
private PreparedStatement getPrepareStatement(Connection conn,String sql,Object[] args) throws SQLException{
    PreparedStatement pstate=conn.prepareStatement(sql);
    for (int i = 0; i < args.length; i++) {
        pstate.setObject(i+1, args[i]);
    }
    return pstate;
}
}
