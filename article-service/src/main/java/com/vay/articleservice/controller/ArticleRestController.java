package com.vay.articleservice.controller;

import com.vay.articleservice.dto.ArticleDto;
import com.vay.articleservice.mapper.ArticleMapper;
import com.vay.articleservice.model.Article;
import com.vay.articleservice.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/article-service")
public class ArticleRestController {

    private final ArticleService articleService;
    private final ArticleMapper articleMapper;

    @GetMapping
    public ResponseEntity<List<ArticleDto>> getArticles() {
        return ResponseEntity.ok(articleMapper.toDtos(articleService.getAll()));
    }

    @GetMapping("{id:\\d+}")
    public ResponseEntity<ArticleDto> getArticleById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(articleMapper.toDto(articleService.getById(id)));
    }

    @PostMapping
    public ResponseEntity<Void> addArticle(@RequestBody ArticleDto article) {
        articleService.createArticle(article.title(), article.content());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id:\\d+}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") Long id) {
        articleService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }
}