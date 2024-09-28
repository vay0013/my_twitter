package com.vay.articleservice.controller;

import com.vay.articleservice.model.Article;
import com.vay.articleservice.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ArticleRestControllerTest {

    @Mock
    ArticleService service;

    @InjectMocks
    ArticleRestController controller;

    @Test
    void getArticles_ReturnsAllArticles() {
        // given
        doReturn(List.of(
                new Article(1L, "title 1", "content 1"),
                new Article(2L, "title 2", "content 2")))
                .when(service).getAll();

        // when
        var result = controller.getArticles();

        // then
        assertEquals(List.of(
                new Article(1L, "title 1", "content 1"),
                new Article(2L, "title 2", "content 2")), result);

        verify(service, times(1)).getAll();
        verifyNoMoreInteractions(service);
    }

    @Test
    void getArticle_ReturnsArticle() {
        // given
        var articleId = 1L;

        doReturn(new Article(1L, "title 1", "content 1"))
                .when(service).getById(1L);

        // when
//        var result = controller.getArticle(articleId);

        // then
//        assertEquals(new Article(1L, "title 1", "content 1"), result);
        
        verify(service, times(1)).getById(1L);
        verifyNoMoreInteractions(service);
    }
}