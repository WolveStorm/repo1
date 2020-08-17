package dao.impl;

import dao.BaseDao;
import dao.FollowDao;
import pojo.Follower;
import pojo.User;

import java.util.List;

/**
 * @version 1.0
 * @ClassName FollowDaoImpl
 * @Description TODO
 * @Author 89255
 */
public class FollowDaoImpl extends BaseDao implements FollowDao {

    @Override
    public int saveFollower(Follower follower) {
        String sql = "insert into W_Follower(id,followId)value(?,?)";
        return update(sql,follower.getId(),follower.getFollowId());
    }

    @Override
    public Follower queryForFollower(User user) {
        String sql="select id,followId from W_Follower where followId = ?";
        return queryForOne(Follower.class,sql,user.getFollowId());
    }
    public Follower queryForFollowerById(Integer id) {
        String sql="select id,followId from W_Follower where Id = ?";
        return queryForOne(Follower.class,sql,id);
    }

    @Override
    public int deleteFollow(Integer followId) {
        String sql="delete from W_follower where followId = ?";
        return update(sql,followId);
    }

    @Override
    public List<Follower> queryForFollowers(User user) {
        String sql="select id,followId from W_Follower where followId = ?";
        return queryForList(Follower.class,sql,user.getFollowId());
    }
}
