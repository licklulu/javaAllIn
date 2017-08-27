package sql;

import javax.sql.DataSource;


import javax.sql.DataSource;

import org.apache.bcel.generic.RETURN;
/**
 * ����ģʽ�������εײ�ʵ��,DataSource��ʵ������Ӧ�ö��������
 * @author JBoss
 *
 */
public class DataSourceFactory {
  
  private DataSourceFactory(){}
  
  public static DataSource get(DataSourceType type ) {
    switch (type) {
    case DBCP:
     return DbcpFactoryCreateDatasource3.me.getDataSource();
    case SIMPLE:
      return SimpleDataSource.me;
    default:
      throw new UnImplementionException();
    }
  }
}

