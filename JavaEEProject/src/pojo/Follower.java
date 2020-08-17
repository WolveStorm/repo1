package pojo;

/**
 * @version 1.0
 * @ClassName Follower
 * @Description TODO
 * @Author 89255
 */
public class Follower {
    private Integer FollowerCount = 0;
    private Integer id;

    public Follower() {
    }

    private int followId;

    public Follower(Integer id, int followId) {
        this.id = id;
        this.followId = followId;
    }

    public int getFollowId() {
        return followId;
    }

    public void setFollowId(int followId) {
        this.followId = followId;
    }


    public Integer getFollowerCount() {
        return FollowerCount;
    }

    public void setFollowerCount(Integer followerCount) {
        FollowerCount = followerCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Follower{" +
                "FollowerCount=" + FollowerCount +
                ", id=" + id +
                ", followId=" + followId +
                '}';
    }
}