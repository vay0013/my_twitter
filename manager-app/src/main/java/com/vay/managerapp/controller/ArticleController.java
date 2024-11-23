package com.vay.managerapp.controller;

import com.vay.managerapp.ArticleMapper;
import com.vay.managerapp.client.ArticleRestClient;
import com.vay.managerapp.controller.payload.RequestArticle;
import com.vay.managerapp.controller.payload.ResponseArticle;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleRestClient articleRestClient;
    private final ArticleMapper articleMapper;

    @GetMapping("/{articleId:d\\+}")
    public ResponseEntity<ResponseArticle> getArticle(@PathVariable Long articleId) {
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
}
