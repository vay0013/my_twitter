package com.vay.articleservice.service;

import com.vay.articleservice.exception.ArticleNotFoundException;
import com.vay.articleservice.model.Article;
import com.vay.articleservice.repository.ArticleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DefaultArticleService implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public List<Article> getAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article getById(long id) {
        return articleRepository.findById(id).orElseThrow(() ->
                new ArticleNotFoundException("Article with id: %d not found".formatted(id)));
    }

    @Override
    @Transactional
    public Article createArticle(String title, String content) {
        return articleRepository.save(new Article(null, title, content));
    }

    @Override
    @Transactional
    public void deleteArticle(long id) {
        articleRepository.deleteById(id);
    }
}
