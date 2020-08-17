package dao;

import pojo.Article;

import java.util.List;

public interface ArticleDao {
    int addArticle(Article article);
    int deleteArticle(Integer id);
    int updateArticle(Article article,Integer id);
    Article queryForArticleById(Integer id);
    Article queryForArticleByTitle(String title);
    Article queryForArticleByAuthor(String author);
    Article queryForArticleByLabel(String label);
    List<Article> queryForArticlesByTitle(String title);
    List<Article> queryForArticlesByAuthor(String author);
    List<Article> queryForArticlesByLabel(String label);
    List<Article> queryForArticles();
    int queryForArticleAmount();
    List<Article> queryForCollect(Integer collectId);
}
