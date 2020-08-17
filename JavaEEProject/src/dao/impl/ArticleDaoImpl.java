package dao.impl;

import dao.ArticleDao;
import dao.BaseDao;
import pojo.Article;

import java.util.List;

/**
 * @version 1.0
 * @ClassName ArticleDaoImpl
 * @Description TODO
 * @Author 89255
 */
public class ArticleDaoImpl extends BaseDao implements ArticleDao {
    @Override
    public int addArticle(Article article) {
        String sql = "insert into W_article(id,title,context,author,label)value(?,?,?,?,?)";
        return update(sql,article.getId(),article.getTitle(),article.getContext(),article.getAuthor(),article.getLabel());
    }

    @Override
    public int deleteArticle(Integer id) {
        String sql = "delete from W_article where id = ?";
        return update(sql,id);
    }

    @Override
    public int updateArticle(Article article,Integer id) {
        String sql = "update W_article set title = ?,context = ?,author = ?,label = ?,collectId = ?  where id =?";
        return update(sql,article.getTitle(),article.getContext(),article.getAuthor(),article.getLabel(),article.getCollectId(),id);
    }

    @Override
    public Article queryForArticleById(Integer id) {
        String sql = "select id,title,context,author,label,collectId from W_article where id = ?";
        return queryForOne(Article.class,sql,id);
    }

    @Override
    public Article queryForArticleByTitle(String title) {
        String sql = "select id,title,context,author,label,collectId from W_article where title = ?";
        return queryForOne(Article.class,sql,title);
    }

    @Override
    public Article queryForArticleByAuthor(String author) {
        String sql = "select id,title,context,author,label,collectId from W_article where author = ?";
        return queryForOne(Article.class,sql,author);
    }

    @Override
    public Article queryForArticleByLabel(String label) {
        String sql = "select id,title,context,author,label,collectId  from W_article where label = ?";
        return queryForOne(Article.class,sql,label);
    }

    @Override
    public List<Article> queryForArticlesByTitle(String title) {
        String sql = "select id,title,context,author,label,collectId from W_article where title like ?";
        return queryForList(Article.class,sql,'%'+title+'%');
    }

    @Override
    public List<Article> queryForArticlesByAuthor(String author) {
        String sql = "select id,title,context,author,label,collectId from W_article where author like ?";
        return queryForList(Article.class,sql,'%'+author+'%');
    }

    @Override
    public List<Article> queryForArticlesByLabel(String label) {
        String sql = "select id,title,context,author,label,collectId from W_article where label like ?";
        return queryForList(Article.class,sql,'%'+label+'%');
    }

    @Override
    public List<Article> queryForArticles() {
        String sql = "select id,title,context,author,label,collectId from W_article";
        return queryForList(Article.class,sql);
    }

    @Override
    public int queryForArticleAmount() {
        String sql = "select count(*) from W_article";
        return Integer.parseInt(queryForSingleValue(sql).toString());
    }

    @Override
    public List<Article> queryForCollect(Integer collectId) {
        String sql = "select id,title,context,author,label,collectId from W_article where collectId = ?";
        return queryForList(Article.class,sql,collectId);
    }


}
