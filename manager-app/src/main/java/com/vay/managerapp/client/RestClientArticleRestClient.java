package com.vay.managerapp.client;

import com.vay.managerapp.model.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.List;

@RequiredArgsConstructor
public class RestClientArticleRestClient implements ArticleRestClient {

    private static final ParameterizedTypeReference<List<Article>> ARTICLE_LIST_TYPE =
            new ParameterizedTypeReference<List<Article>>() {
            };

    private final RestClient restClient;

    @Override
    public List<Article> findAllArticles() {
        return restClient
                .get()
                .uri("api/v1/article-service")
                .retrieve()
                .body(ARTICLE_LIST_TYPE);
    }

    @Override
    public Article findArticle(long id) {
        return null;
    }

    @Override
    public void createArticle(String title, String content) {

    }

    @Override
    public void updateArticle(long id, String title, String content) {

    }

    @Override
    public void deleteArticle(long id) {

    }
}
