package service;

import dao.ArticleDao;
import dao.impl.ArticleDaoImpl;
import pojo.Article;

import java.util.List;

/**
 * @version 1.0
 * @ClassName ArticleService
 * @Description TODO
 * @Author 89255
 */
public class    ArticleService {
    private ArticleDao articleDao = new ArticleDaoImpl();
    public int addArticle(Article article){
        return articleDao.addArticle(article);
    }
    public int deleteArticle(Integer id){
        return articleDao.deleteArticle(id);
    }
    public int updateArticle(Article article,Integer id){
        return articleDao.updateArticle(article,id);
    }
    public int queryForTotalArticleAmount(){
        return articleDao.queryForArticleAmount();
    }
    public Article queryByTitle(String title){
        return articleDao.queryForArticleByTitle(title);
    }
    public Article queryByAuthor(String author){
        return articleDao.queryForArticleByAuthor(author);
    }
    public Article queryByLabel(String label){
        return articleDao.queryForArticleByLabel(label);
    }
    public List<Article> queryArticlesByTitle(String title){
        return articleDao.queryForArticlesByTitle(title);
    }
    public List<Article> queryArticlesByLabel(String label){
        return articleDao.queryForArticlesByLabel(label);
    }
    public int articleToCollect(Article article,Integer id){
        article.setCollectId(id);
        return articleDao.updateArticle(article,article.getId());
    }
    public List<Article> queryArticlesByAuthor(String author){
        return articleDao.queryForArticlesByAuthor(author);
    }
    public void ListToOtherList(List<Article> findList,List<Article> list){
        for(int i = 0;i<findList.size();i++){
            list.add(findList.get(i));
        }
    }
    public List<Article> queryForCollectArticle(Integer collectId){
        return articleDao.queryForCollect(collectId);
    }
}
