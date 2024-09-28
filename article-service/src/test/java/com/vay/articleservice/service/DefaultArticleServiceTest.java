package com.vay.articleservice.service;

import com.vay.articleservice.exception.ArticleNotFoundException;
import com.vay.articleservice.model.Article;
import com.vay.articleservice.repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.stream.LongStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class DefaultArticleServiceTest {

    @Mock
    ArticleRepository repository;

    @InjectMocks
    DefaultArticleService service;

    @Test
    void getAll_DoesReturnArticles() {
        // given
        var articles = LongStream.range(0, 3)
                .mapToObj(i -> new Article(i, "title ".formatted(i), "content ".formatted(i)))
                .toList();

        doReturn(articles).when(repository).findAll();

        // when
        var result = service.getAll();

        // then
        assertThat(result)
                .isNotNull()
                .hasSize(3)
                .isEqualTo(articles);

        verify(repository, times(1)).findAll();
        verifyNoMoreInteractions(repository);
    }

    @Test
    void getById_ArticleExists_ReturnArticle() {
        // given
        var article = new Article(1L, "title 1", "content 1");

        doReturn(Optional.of(article)).when(repository).findById(1L);

        // when
        var result = service.getById(1L);

        // then
        assertThat(result)
                .isNotNull()
                .isEqualTo(article);

        verify(repository, times(1)).findById(1L);
        verifyNoMoreInteractions(repository);
    }

    @Test
    void getById_ArticleDoesNotExist_ThrowsNoSuchElementException() {
        // given

        // when
        assertThatThrownBy(() -> service.getById(1L))
                .isInstanceOf(ArticleNotFoundException.class)
                .hasMessage("Article with id: 1 not found");

        // then
        verify(repository, times(1)).findById(1L);
        verifyNoMoreInteractions(repository);
    }

//    @Test
//    void createArticle_ReturnsArticle() {
//        // given
//        var title = "title";
//        var content = "content";
//
//        doReturn(new Article(1L, "title", "content"))
//                .when(repository)
//                .save(new Article(null, "title", "content"));
//
//        // when
//        var result = service.createArticle(title, content);
//
//        // then
//        assertThat(result).isEqualTo(new Article(1L, "title", "content"));
//        verify(repository, times(1))
//                .save(new Article(null, "title", "content"));
//        verifyNoMoreInteractions(repository);
//    }

    @Test
    void deleteArticle_DeletesArticle() {
        // given
        var articleId = 1L;

        // when
        service.deleteArticle(articleId);

        // then
        verify(repository, times(1)).deleteById(articleId);
        verifyNoMoreInteractions(repository);
    }
}