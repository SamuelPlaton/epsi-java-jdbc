package fr.epsi.jdbc.dao;

import fr.epsi.jdbc.entities.Article;

import java.util.List;

public interface ArticleDao {
    List<Article> extraire();
    void insert(Article article);
    int update(String ref, double prix);
    boolean delete(Article article);
}
