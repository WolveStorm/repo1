package pojo;

import java.util.LinkedList;
import java.util.List;

/**
 * @version 1.0
 * @ClassName User
 * @Description TODO
 * @Author 89255
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String gentle;
    private int age;
    private int followId;
    private int collectId;

    public User(Integer id, String username, String password, String name, String gentle, int age, int followId, int collectId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.gentle = gentle;
        this.age = age;
        this.followId = followId;
        this.collectId = collectId;
    }

    public int getCollectId() {
        return collectId;
    }

    public void setCollectId(int collectId) {
        this.collectId = collectId;
    }

    public int getFollowId() {
        return followId;
    }

    public void setFollowId(int followId) {
        this.followId = followId;
    }

    public User(Integer id, String username, String password, String name, String gentle, int age, int followId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.gentle = gentle;
        this.age = age;
        this.followId = followId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", gentle='" + gentle + '\'' +
                ", age=" + age +
                ", followId=" + followId +
                ", collectId=" + collectId +
                '}';
    }

    public User(String name, String gentle, int age) {
        this.name = name;
        this.gentle = gentle;
        this.age = age;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGentle() {
        return gentle;
    }

    public void setGentle(String gentle) {
        this.gentle = gentle;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
