package web;

import org.apache.poi.util.IOUtils;
import pojo.Article;
import pojo.User;
import service.ArticleService;
import service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @version 1.0
 * @ClassName ArticleServlet
 * @Description TODO
 * @Author 89255
 */
public class ArticleServlet extends baseServlet {
    UserService userService = new UserService();
    ArticleService articleService = new ArticleService();
    protected void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String find = req.getParameter("find");
        List<Article> articles = new LinkedList<>();
        if (articleService.queryArticlesByAuthor(find) != null) {
            articleService.ListToOtherList(articleService.queryArticlesByAuthor(find), articles);
        }
        if (articleService.queryArticlesByTitle(find) != null) {
            articleService.ListToOtherList(articleService.queryArticlesByTitle(find), articles);
        }
        if (articleService.queryArticlesByLabel(find) != null) {
            articleService.ListToOtherList(articleService.queryArticlesByLabel(find), articles);
        }
        req.getSession().setAttribute("articles", articles);
        req.getRequestDispatcher("/pages/article/query_show.jsp").forward(req, resp);
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userService.login(username, password);
        if (user != null&&!username.equals("admin")) {
            req.getSession().setAttribute("user", user);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }else if(user != null&&username.equals("admin")){
            req.getSession().setAttribute("manager",user);
            req.getRequestDispatcher("/pages/manager/login_success.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }

    }

    protected void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        req.getSession().setAttribute("user", user);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");
        String name = req.getParameter("name");
        String gentle = req.getParameter("sex");
        int age = Integer.parseInt(req.getParameter("age"));
        int id = userService.getUserCount();
        int followId = id;
        int collectId = id;
        if (!userService.existUser(username) && password1.equals(password2)) {
            User user = new User(++id, username, password1, name, gentle, age, followId,collectId);
            userService.regist(user);
            req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
        } else if (userService.existUser(username)) {
            System.out.println("已经有账号了");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else if (password1.equals(password2)) {
            System.out.println("密码重新输入错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }

    protected void upLoad(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String label = req.getParameter("label");
        String context = req.getParameter("context");
        String author = req.getParameter("author");
        int id = articleService.queryForTotalArticleAmount();
        Article article = new Article(++id, title, context, author, label);
        articleService.addArticle(article);
        req.getRequestDispatcher("/pages/article/upload_success.jsp").forward(req, resp);

    }

    protected void queryShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Article> list = (List<Article>) req.getSession().getAttribute("articles");
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String label = req.getParameter("label");
        User user = (User)req.getSession().getAttribute("user");
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i).getTitle()).equals(title)) {
                if (list.get(i).getAuthor().equals(author)) {
                    if (list.get(i).getLabel().equals(label)) {
                        if (!author.equals(req.getAttribute("author"))) {
                            req.getSession().setAttribute("author", author);
                            req.getSession().setAttribute("article", list.get(i));
                        }
                    }
                }
            }
            if(list.get(i).getCollectId()==user.getCollectId()){
                req.getSession().setAttribute("f","true");

            }
        }
        req.getSession().setAttribute("method",2);
        req.getSession().setAttribute("user",user);
        req.getRequestDispatcher("/pages/article/article_show.jsp").forward(req, resp);
    }
    protected void deleteCollect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int method = (int) req.getSession().getAttribute("method");
        if(method==1){
            Article article =(Article)req.getSession().getAttribute("article");
            article.setCollectId(0);
            articleService.updateArticle(article,article.getId());
        }else if(method==2){
            Article article =(Article)req.getSession().getAttribute("article");
            article.setCollectId(0);
            articleService.updateArticle(article,article.getId());
        }
        req.getRequestDispatcher("/pages/article/deleteCollectSuccess.jsp").forward(req, resp);
    }
    protected void myArticle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String author = user.getName();
        List<Article> articles = articleService.queryArticlesByAuthor(author);
        req.getSession().setAttribute("myArticles", articles);
        req.getSession().setAttribute("user", user);
        req.getRequestDispatcher("/pages/article/myArticle_show.jsp").forward(req, resp);
    }

    protected void myArticleShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Article> list = (List<Article>) req.getSession().getAttribute("myArticles");
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String label = req.getParameter("label");
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i).getTitle()).equals(title)) {
                if (list.get(i).getAuthor().equals(author)) {
                    if (list.get(i).getLabel().equals(label)) {
                        if (!author.equals(req.getAttribute("author"))) {
                            req.getSession().setAttribute("author", author);
                            req.getSession().setAttribute("article", list.get(i));
                        }
                    }
                }
            }
        }
        req.getRequestDispatcher("/pages/article/article_show.jsp").forward(req, resp);
    }

    protected void collect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Article article = (Article)req.getSession().getAttribute("article");
        User user = (User)req.getSession().getAttribute("user");
        articleService.articleToCollect(article,user.getCollectId());
        req.getSession().setAttribute("user",user);
        req.getRequestDispatcher("/pages/article/collect_success.jsp").forward(req,resp);
    }
    protected void showCollect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<Article> collectArticles = articleService.queryForCollectArticle(user.getCollectId());
        req.getSession().setAttribute("collectArticles",collectArticles);
        req.getRequestDispatcher("pages/article/collectArticle.jsp").forward(req,resp);
    }
    protected void ToCollectPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Article> list = (List<Article>)req.getSession().getAttribute("collectArticles");
        User user = (User)req.getSession().getAttribute("user");
        for(int i = 0;i<list.size();i++){
            if((list.get(i).getCollectId())==(user.getCollectId())){
                req.getSession().setAttribute("article",list.get(i));
                req.getSession().setAttribute("sign","已收藏");
            }
        }
        req.getSession().setAttribute("user",user);
        req.getSession().setAttribute("method",1);
        req.getRequestDispatcher("pages/article/article_show.jsp").forward(req,resp);
    }
    protected void download(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取下载名字
        String fileName = "a.xls";
        //读取要下载的文件
        ServletContext servletContext = getServletContext();
        String type = servletContext.getMimeType("/"+fileName);//获得类型
        resp.setContentType(type);
        //告诉客户端下载操作
        resp.setHeader("Content-Disposition","attachment;filename="+fileName);
        InputStream is = servletContext.getResourceAsStream("/"+fileName);//放文件路径
        //获取响应的输出流，把下载的传给客户端
        OutputStream os = resp.getOutputStream();
        IOUtils.copy(is,os);

    }
}