package utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @version 1.0
 * @ClassName jdbcUtils
 * @Description TODO
 * @Author 89255
 */
public class jdbcUtils {
    private static DruidDataSource druidDataSource;
    //初始化德鲁伊数据库
    static{
        try {
            Properties pro = new Properties();
            InputStream is = jdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            pro.load(is);
            druidDataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static Connection connect(){
        Connection conn = null;
        try {
            conn = druidDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void closeConnection(Connection conn){
        try {
            if(conn!=null){
            conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
