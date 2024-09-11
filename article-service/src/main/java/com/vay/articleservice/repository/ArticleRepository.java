package com.vay.articleservice.repository;

import com.vay.articleservice.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
