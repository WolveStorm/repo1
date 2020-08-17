package web;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import pojo.Article;
import pojo.User;
import service.ArticleService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @version 1.0
 * @ClassName ManagerServlet
 * @Description TODO
 * @Author 89255
 */
public class ManagerServlet extends baseServlet {
    private ArticleService articleService = new ArticleService();
    private UserService userService = new UserService();
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
        req.getRequestDispatcher("/pages/manager/query_show.jsp").forward(req, resp);
    }
    protected void queryShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Article> list = (List<Article>) req.getSession().getAttribute("articles");
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
        req.getRequestDispatcher("/pages/manager/article_show.jsp").forward(req, resp);
    }
    protected void deleteArticle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Article article =(Article) req.getSession().getAttribute("article");
        articleService.deleteArticle(article.getId());
        req.getRequestDispatcher("/pages/manager/delete_success.jsp").forward(req,resp);
    }
    protected void queryUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String find = req.getParameter("find");
        User user = userService.findUser(find);
        req.getSession().setAttribute("FindUser",user);
        req.getRequestDispatcher("/pages/manager/queryUser_show.jsp").forward(req,resp);
    }
    protected void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)req.getSession().getAttribute("FindUser");
        userService.deleteUser(user.getId());
        req.getRequestDispatcher("/pages/manager/deleteUser_success.jsp").forward(req,resp);
    }
    protected void articleAmount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int amount =  articleService.queryForTotalArticleAmount();
        req.getSession().setAttribute("amount",amount);
        req.getRequestDispatcher("pages/manager/articleAmount.jsp").forward(req,resp);
    }
    protected void upLoad(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        //判断是否有multipart属性
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        try {
            if(isMultipart) {//开始上传
                FileItemFactory fileItemFactory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
                //通过parseRequest解析form中的字段，并保存到item集合中
                List<FileItem> items = upload.parseRequest(req);
                Iterator<FileItem> iterator = items.iterator();
                while (iterator.hasNext()) {
                    FileItem fileItem = iterator.next();
                    if (fileItem.getFieldName().equals("excel")) {
                        //根据name判断item是什么
                        //上传文件
                        String fileName = fileItem.getName();//get文件名
                        //get文件内容 fileitem为文件内容
                        String path = "D:\\JavaEEProject\\web";
                        File file = new File(path, fileName);
                        fileItem.write(file);
                    }
                }
                //解析
                InputStream is = new FileInputStream(new File("D:\\JavaEEProject\\web\\new.xls"));
                HSSFWorkbook workbook = new HSSFWorkbook(is);
                HSSFSheet sheet = workbook.getSheetAt(0);
                Row dataRow = sheet.getRow(1);
                int len;
                String[] strings = new String[4];
                for (len = 0; len < 4; len++) {
                    Cell cell = dataRow.getCell(len);
                    strings[len] = cell.getStringCellValue();
                }
                System.out.println("作者: "+strings[0]+"  "+"标题: "+strings[1] + " "+"文章："+strings[2]+" "+"类别："+strings[3]);
            }
            req.getRequestDispatcher("pages/manager/upExcel_success.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
