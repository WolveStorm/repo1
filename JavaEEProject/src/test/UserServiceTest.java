package test;

import org.junit.Test;
import pojo.User;
import service.UserService;

/**
 * @version 1.0
 * @ClassName UserServiceTest
 * @Description TODO
 * @Author 89255
 */
public class UserServiceTest {
    UserService userService = new UserService();
    @Test
    public void test() {
        userService.deleteUser(2);
    }
}
