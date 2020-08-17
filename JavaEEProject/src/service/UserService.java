package service;

import dao.BaseDao;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.Follower;
import pojo.User;

/**
 * @version 1.0
 * @ClassName UserServuce
 * @Description TODO
 * @Author 89255
 */
public class UserService {
    private UserDao userDao = new UserDaoImpl();
    public User login(String username,String password){
        return userDao.queryUserByPassWordAndUserName(username,password);
    }
    public User getUserByFollowId(Integer id){
        return userDao.queryUserByFollowId(id);
    }
    public User getUserById(Integer id ){
        return userDao.queryUserById(id);
    }
    public int getUserCount(){
      return  userDao.queryUserCount();
    }
    public void regist(User user){
        userDao.saveUser(user);
    }
    public int deleteUser(Integer id){
        return userDao.deleteUser(id);
    }
    public int updateUserItem(User user,Integer id){
        return userDao.updateUser(user,id);
    }
    public boolean existUser(String username){
        if( userDao.queryUserByUserName(username)!=null){
            return true;
        }
        return false;
    }
    public User findUser(String name){
        if( userDao.queryUserByName(name)!=null){
            return userDao.queryUserByName(name);
        }
        return null;
    }
}
