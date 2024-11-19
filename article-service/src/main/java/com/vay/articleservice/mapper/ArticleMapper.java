package com.vay.articleservice.mapper;

import com.vay.articleservice.controller.dto.ArticleDto;
import com.vay.articleservice.model.Article;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ArticleMapper {
    ArticleDto toDto(Article article);

    List<ArticleDto> toDtos(List<Article> articles);
}