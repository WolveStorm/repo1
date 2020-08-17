package test;

import org.junit.Test;
import pojo.Article;
import service.ArticleService;

import java.util.List;

/**
 * @version 1.0
 * @ClassName ArticleServiceTest
 * @Description TODO
 * @Author 89255
 */
public class ArticleServiceTest {
    ArticleService articleService = new ArticleService();
    @Test
    public void test() {
        List<Article> list =  articleService.queryForCollectArticle(0);
        for (Article article:list){
            System.out.println(article);
        }
    }
}
