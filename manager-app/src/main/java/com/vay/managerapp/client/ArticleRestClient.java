package com.vay.managerapp.client;

import com.vay.managerapp.model.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleRestClient {

    List<Article> findAllArticles();

    Optional<Article> findArticle(long id);

    Article createArticle(String title, String content);

    void updateArticle(long id, String title, String content);

    void deleteArticle(long id);

}
