package dao;

import pojo.Follower;
import pojo.User;

import java.util.List;

/**
 * @version 1.0
 * @ClassName FollowDao
 * @Description TODO
 * @Author 89255
 */
public interface FollowDao {
    int saveFollower(Follower follower);
    Follower queryForFollower(User user);
    List<Follower> queryForFollowers(User user);
    Follower queryForFollowerById(Integer id);
    int deleteFollow(Integer followId);
}
