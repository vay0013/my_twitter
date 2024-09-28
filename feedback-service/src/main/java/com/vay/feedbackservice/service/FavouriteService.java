package com.vay.feedbackservice.service;

import com.vay.feedbackservice.model.FavouriteArticle;

import java.util.List;

public interface FavouriteService {
    List<FavouriteArticle> getAllFavouriteArticles(String userId);

    FavouriteArticle addToFavourite(long articleId, String userId);

    void removeFromFavourite(long articleId, String userId);
}
