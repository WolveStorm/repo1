package dao.impl;

import dao.BaseDao;
import dao.UserDao;
import pojo.User;

/**
 * @version 1.0
 * @ClassName UserDao
 * @Description TODO
 * @Author 89255
 */
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryUserByName(String name) {
        String sql = "select name,gentle,age,id,password,username,followId from W_user where name = ?";
        return queryForOne(User.class,sql,name);
    }

    @Override
    public User queryUserByPassWordAndUserName(String username, String password) {
        String sql = "select id,followId,password,username,name,gentle,age,collectId from W_user where username = ? and password = ?";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public User queryUserById(Integer id) {
        String sql = "select name,gentle,age,id,password,username,followId from W_user where id = ?";
        return queryForOne(User.class,sql,id);
    }

    @Override
    public User queryUserByFollowId(Integer id) {
        String sql ="select id,followId,password,username,name,gentle,age,collectId from W_user where followId = ?";
        return queryForOne(User.class,sql,id);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into W_user(id,username,password,name,gentle,age,followId,collectId)value(?,?,?,?,?,?,?,?)";
        return update(sql,user.getId(),user.getUsername(),user.getPassword(),user.getName(),user.getGentle(),user.getAge(),user.getFollowId(),user.getCollectId());
    }

    @Override
    public int queryUserCount() {
        String sql = "select count(*) from W_user";
        return Integer.parseInt(queryForSingleValue(sql).toString());
    }

    @Override
    public User queryUserByUserName(String username) {
        String sql = "select name,gentle,age,id,follower,username,password from W_user where username = ? ";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public int updateUser(User user,Integer id) {
        String sql = "update W_user set name = ?,gentle = ?,age = ?  where id = ?";
        return update(sql,user.getName(),user.getGentle(),user.getAge(),id);
    }
    public int deleteUser(Integer id){
        String sql = "delete from W_user where id = ?";
        return update(sql,id);
    }
}
