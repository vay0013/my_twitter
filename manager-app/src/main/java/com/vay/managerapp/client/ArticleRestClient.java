package com.vay.managerapp.client;

import com.vay.managerapp.model.Article;

import java.util.List;

public interface ArticleRestClient {

    List<Article> findAllArticles();

    Article findArticle(long id);

    void createArticle(String title, String content);

    void updateArticle(long id, String title, String content);

    void deleteArticle(long id);

}
