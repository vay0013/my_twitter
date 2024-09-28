package com.vay.articleservice.controller.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.vay.articleservice.model.Article}
 */
public record ArticleDto(String title, String content) implements Serializable {
}