package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.jdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @version 1.0
 * @ClassName BaseDao
 * @Description TODO
 * @Author 89255
 */
public abstract class BaseDao {
    private QueryRunner queryRunner = new QueryRunner();
    //更新
    public int update(String sql,Object...args){
        Connection conn = null;
        try {
            conn = jdbcUtils.connect();
            return queryRunner.update(conn,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            jdbcUtils.closeConnection(conn);
        }
        return -1;
    }
    //查询一个对象
    public <T> T queryForOne(Class<T> type,String sql,Object...args){
        Connection conn = null;
        try {
            conn = jdbcUtils.connect();
            return queryRunner.query(conn,sql,new BeanHandler<>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.closeConnection(conn);
        }
        return null;
    }
    //查询一列对象
    public <T> List<T> queryForList(Class<T> type,String sql,Object...args){
        Connection conn = null;
        try {
            conn = jdbcUtils.connect();
            return queryRunner.query(conn,sql,new BeanListHandler<>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.closeConnection(conn);
        }
        return null;
    }
    //查询单个值
    public Object queryForSingleValue(String sql,Object...args){
        Connection conn = null;
        try {
            conn = jdbcUtils.connect();
            return queryRunner.query(conn,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.closeConnection(conn);
        }
        return null;
    }
}
