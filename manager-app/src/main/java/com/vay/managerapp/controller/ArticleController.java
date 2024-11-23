package com.vay.managerapp.controller;

import com.vay.managerapp.ArticleMapper;
import com.vay.managerapp.client.ArticleRestClient;
import com.vay.managerapp.controller.payload.RequestArticle;
import com.vay.managerapp.controller.payload.ResponseArticle;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleRestClient articleRestClient;
    private final ArticleMapper articleMapper;

    @GetMapping("/{articleId:d\\+}")
    public ResponseEntity<ResponseArticle> getArticle(@PathVariable("articleId") Long articleId) {
        return ResponseEntity.ok(articleMapper.toDto(articleRestClient.findArticle(articleId)));
    }

    @GetMapping
    public ResponseEntity<List<ResponseArticle>> getArticles() {
        return ResponseEntity.ok(articleMapper.toDto(articleRestClient.findArticles()));
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseArticle> createArticle(@RequestBody RequestArticle article) {
        return ResponseEntity.ok(
                articleMapper.toDto(articleRestClient.createArticle(article.title(), article.content())));
    }

    @PutMapping("{articleId:d\\+}")
    public ResponseEntity<Void> updateArticle(
            @PathVariable("articleId") Long articleId,
            @RequestBody RequestArticle article) {
        articleRestClient.updateArticle(articleId, article.title(), article.content());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{articleId:d\\+}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("articleId") Long articleId) {
        articleRestClient.deleteArticle(articleId);
        return ResponseEntity.noContent().build();
    }
}
