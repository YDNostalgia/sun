package gxa.utils;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static DataSource dataSource = null;
    static {
        InputStream inputStream = DBConnection.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);

            dataSource = DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //获取连接
    public static Connection getConnection(){
        Connection connection;
        try {
            connection =  dataSource.getConnection();
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //关闭连接
    public static void close(PreparedStatement ps,Connection connection){
        if(ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    //关闭连接
    public static void close(ResultSet rs,PreparedStatement ps, Connection connection){
        if( rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
       close(ps,connection);
    }
}
