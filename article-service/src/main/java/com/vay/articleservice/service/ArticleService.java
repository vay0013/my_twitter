package com.vay.articleservice.service;

import com.vay.articleservice.model.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getAll();

    Article getById(long id);

    Article createArticle(String title, String content);

    void deleteArticle(long id);
}
