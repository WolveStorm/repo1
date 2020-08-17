package test;

import org.junit.Test;
import utils.jdbcUtils;

import java.sql.Connection;

/**
 * @version 1.0
 * @ClassName jdbcUtilsTest
 * @Description TODO
 * @Author 89255
 */
public class jdbcUtilsTest {
    @Test
    public void test(){
        Connection connection = jdbcUtils.connect();
        System.out.println(connection);
    }

}
