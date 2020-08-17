package dao;

import pojo.User;

public interface UserDao {
    //查找用户byName
    User queryUserByName(String name);
    //查找用户byUsername&Password
    User queryUserByPassWordAndUserName(String username,String password);
    //保存用户数据
    User queryUserById(Integer id);
    User queryUserByFollowId(Integer id);
    int  saveUser(User user);
    int queryUserCount();
    User queryUserByUserName(String username);
    int updateUser(User user,Integer id);
    int deleteUser(Integer id);
}
