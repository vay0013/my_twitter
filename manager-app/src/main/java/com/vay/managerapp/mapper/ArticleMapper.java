package com.vay.managerapp.mapper;

import com.vay.managerapp.controller.payload.ResponseArticle;
import com.vay.managerapp.model.Article;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ArticleMapper {
    Article toEntity(ResponseArticle responseArticle);

    ResponseArticle toDto(Article article);
    List<ResponseArticle> toDto(List<Article> article);
}