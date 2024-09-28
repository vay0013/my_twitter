package com.vay.favouriteservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("favourite-product")
public class FavouriteArticle {

    @Id
    private UUID id;

    private Long articleId;

    private Long userId;
}
