package test;

import dao.ArticleDao;
import dao.BaseDao;
import dao.impl.ArticleDaoImpl;
import org.junit.Test;
import pojo.Article;

/**
 * @version 1.0
 * @ClassName daoTest
 * @Description TODO
 * @Author 89255
 */
public class ArticleDaoTest {
    private ArticleDao baseDao = new ArticleDaoImpl();
    @Test
    public void test(){
//        Article article = new Article(1,"李姐","这波啊是肉蛋冲击","大司马","下饭");
//        baseDao.addArticle(article);
//        baseDao.deleteArticle(1);
//       Article article1 =  baseDao.queryForArticleByAuthor("大司马");
//        System.out.println(article1);
//        Article article1;
//        article1 = baseDao.queryForArticleById(1);
//        System.out.println(article1);
        Article article2 = new Article(null,"abc","123","ss","ssh");
        baseDao.updateArticle(article2,1);

    }
}
