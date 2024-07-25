package com.vay.articleservice.repository;

import com.vay.articleservice.model.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}
