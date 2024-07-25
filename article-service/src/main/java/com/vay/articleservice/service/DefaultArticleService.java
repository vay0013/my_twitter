package com.vay.articleservice.service;

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
        return (List<Article>) articleRepository.findAll();
    }

    @Override
    public Article getById(Long id) {
        return articleRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Article with id: %s not found".formatted(id)));
    }

    @Override
    @Transactional
    public void createArticle(String title, String content) {
        articleRepository.save(new Article(null, title, content));
    }

    @Override
    @Transactional
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }
}
