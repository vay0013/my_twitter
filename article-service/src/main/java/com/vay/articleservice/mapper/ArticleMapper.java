package com.vay.articleservice.mapper;

import com.vay.articleservice.dto.ArticleDto;
import com.vay.articleservice.model.Article;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ArticleMapper {
    Article toEntity(ArticleDto articleDto);

    ArticleDto toDto(Article article);

    List<ArticleDto> toDtos(List<Article> articles);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Article partialUpdate(ArticleDto articleDto, @MappingTarget Article article);
}