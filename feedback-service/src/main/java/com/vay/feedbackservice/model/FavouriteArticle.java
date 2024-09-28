package com.vay.feedbackservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("favourites")
public class FavouriteArticle {
    @Id
    private UUID id;

    private Long articleId;

    private String userId;
}
