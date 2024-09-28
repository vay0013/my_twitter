package com.vay.feedbackservice.repository;

import com.vay.feedbackservice.model.FavouriteArticle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface FavouriteArticleRepository extends MongoRepository<FavouriteArticle, UUID> {
    List<FavouriteArticle> findAllByUserId(String userId);

    void deleteByArticleIdAndUserId(long articleId, String userId);
}