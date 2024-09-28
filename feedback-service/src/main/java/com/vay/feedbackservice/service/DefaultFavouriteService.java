package com.vay.feedbackservice.service;

import com.vay.feedbackservice.model.FavouriteArticle;
import com.vay.feedbackservice.repository.FavouriteArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DefaultFavouriteService implements FavouriteService {

    private final FavouriteArticleRepository favouriteArticleRepository;

    @Override
    public List<FavouriteArticle> getAllFavouriteArticles(String userId) {
        return favouriteArticleRepository.findAllByUserId(userId);
    }

    @Override
    public FavouriteArticle addToFavourite(long articleId, String userId) {
        return favouriteArticleRepository.save(new FavouriteArticle(UUID.randomUUID(), articleId, userId));
    }

    @Override
    public void removeFromFavourite(long articleId, String userId) {
        favouriteArticleRepository.deleteByArticleIdAndUserId(articleId, userId);
    }
}
