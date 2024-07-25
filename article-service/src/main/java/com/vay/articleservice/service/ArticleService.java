package com.vay.articleservice.service;

import com.vay.articleservice.model.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getAll();

    Article getById(Long id);

    void createArticle(String title, String content);

    void deleteArticle(Long id);
}
