package web;

import dao.BaseDao;
import pojo.Follower;
import pojo.User;
import service.FollowService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @version 1.0
 * @ClassName UserServlet
 * @Description TODO
 * @Author 89255
 */
public class UserServlet extends baseServlet {
    private UserService userService = new UserService();
    private FollowService followService = new FollowService();
    protected void updateItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String gentle = req.getParameter("sex");
        int age = Integer.parseInt(req.getParameter("age"));
        User user = (User)req.getSession().getAttribute("user");
        System.out.println(user);
        user.setAge(age);
        user.setGentle(gentle);
        user.setName(name);
        userService.updateUserItem(user,user.getId());
        req.getSession().setAttribute("user",user);
        req.getRequestDispatcher("/pages/user/userItem.jsp").forward(req,resp);
    }
    protected void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String find = req.getParameter("find");
        User user = userService.findUser(find);
        req.getSession().setAttribute("FindUser",user);
        User user1 = (User)req.getSession().getAttribute("user");
        Follower follower = followService.getFollowerById(user1.getId());
        if(follower!=null) {
            if (user.getFollowId() == follower.getFollowId()) {
                req.getSession().setAttribute("flag", "true");
            }
        }
        req.getSession().setAttribute("user",user1);
        req.getRequestDispatcher("/pages/user/query_show.jsp").forward(req,resp);
    }
    protected void follow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user1 = (User)req.getSession().getAttribute("user");
        User user2 = (User)req.getSession().getAttribute("FindUser");
        Follower follower = followService.UserToFollower(user2,user1);
        followService.saveFollow(follower);
        req.getSession().setAttribute("user",user1);
        req.getRequestDispatcher("/pages/user/follow_success.jsp").forward(req,resp);
    }
    protected void deleteFollow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)req.getSession().getAttribute("FindUser");
        followService.deleteFollow(user.getFollowId());
        req.getRequestDispatcher("/pages/user/deleteFollowSuccess.jsp").forward(req,resp);
    }
    protected void showFans(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<User> followers = followService.getFollowers(user);
        req.getSession().setAttribute("count",followers.size());
        req.getSession().setAttribute("followers",followers);
        req.getRequestDispatcher("/pages/user/showFans.jsp").forward(req,resp);
    }
    protected void showFollower(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> followers = (List<User>)req.getSession().getAttribute("followers");
        String name = req.getParameter("name");
        for(int i = 0;i<followers.size();i++){
            if(followers.get(i).getName().equals(name)){
                req.getSession().setAttribute("follower",followers.get(i));
            }
        }
        req.getRequestDispatcher("/pages/user/followerItem.jsp").forward(req,resp);
    }
}
