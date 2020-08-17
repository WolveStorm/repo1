package service;

import dao.impl.FollowDaoImpl;
import pojo.Follower;
import pojo.User;

import java.text.Format;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @ClassName FollowService
 * @Description TODO
 * @Author 89255
 */
public class FollowService {
    private UserService userService = new UserService();
    private FollowDaoImpl followDao = new FollowDaoImpl();
    public int saveFollow(Follower follower){
        return followDao.saveFollower(follower);
    }
    public Follower UserToFollower(User user,User followUser){
        Follower follower1 = new Follower(followUser.getId(),user.getFollowId());
        return follower1;
    }
    public List<User> getFollowers(User user){
        List<Follower> followers = followDao.queryForFollowers(user);
        List<User> users = new ArrayList<>();
        for(Follower follower:followers){
            users.add(userService.getUserById(follower.getFollowId()));
        }
        return users;
    }
    public Follower getFollowerById(Integer id){
       Follower follower =  followDao.queryForFollowerById(id);
        return follower;
    }
    public User getFollower(User user) {
        Follower follower =  followDao.queryForFollower(user);
        return userService.getUserByFollowId(follower.getFollowId());
    }
    public int deleteFollow(Integer followId){
        return followDao.deleteFollow(followId);
    }
}
