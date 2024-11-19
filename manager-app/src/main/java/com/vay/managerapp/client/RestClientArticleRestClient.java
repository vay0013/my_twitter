package com.vay.managerapp.client;

import com.vay.managerapp.controller.payload.NewArticlePayload;
import com.vay.managerapp.exception.BadRequestException;
import com.vay.managerapp.model.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
public class RestClientArticleRestClient implements ArticleRestClient {

    private static final ParameterizedTypeReference<List<Article>> ARTICLE_LIST_TYPE =
            new ParameterizedTypeReference<>() {
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
    public Optional<Article> findArticle(long articleId) {
        try {
            return Optional.ofNullable(restClient
                    .get()
                    .uri("api/v1/article-service/{articleId}")
                    .retrieve()
                    .body(Article.class));
        } catch (HttpClientErrorException.BadRequest exception) {
            return Optional.empty();

        }
    }

    @Override
    public Article createArticle(String title, String content) {
        try {
            return restClient
                    .post()
                    .uri("api/v1/article-service")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(new NewArticlePayload(title, content))
                    .retrieve()
                    .body(Article.class);
        } catch (HttpClientErrorException.BadRequest exception) {
            ProblemDetail problemDetail = exception.getResponseBodyAs(ProblemDetail.class);
            throw new BadRequestException((List<String>) problemDetail.getProperties().get("errors"));
        }
    }

    @Override
    public void updateArticle(long id, String title, String content) {
        
    }

    @Override
    public void deleteArticle(long articleId) {
        try {
            restClient.delete()
                    .uri("api/v1/article-service/{articleId}")
                    .retrieve()
                    .toBodilessEntity();
        } catch (HttpClientErrorException.NotFound exception) {
            throw new NoSuchElementException(exception.getResponseBodyAsString());
        }
    }
}