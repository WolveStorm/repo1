package test;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import org.junit.Test;
import pojo.User;

/**
 * @version 1.0
 * @ClassName UserDaoTest
 * @Description TODO
 * @Author 89255
 */
public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();
    @Test
    public void test(){
//        User user = new User("admin","123456","phm","man",18);
//        userDao.saveUser(user);
//        System.out.println(userDao.queryUserByName("phm"));
        System.out.println(userDao.queryUserByPassWordAndUserName("admin","123456"));
    }
}