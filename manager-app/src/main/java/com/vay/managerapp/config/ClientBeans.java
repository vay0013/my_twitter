package com.vay.managerapp.config;

import com.vay.managerapp.client.ArticleRestClient;
import com.vay.managerapp.client.RestClientArticleRestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.web.client.RestClient;

@Configuration
public class ClientBeans {
    @Bean
    public ArticleRestClient articleRestClient(
            @Value("vay.services.article.uri") String articleBaseUri,
            @Value("vay.services.article.registration-id") String registrationId,
            ClientRegistrationRepository clientRegistrationRepository,
            OAuth2AuthorizedClientRepository authorizedClient
    ) {
        return RestClientArticleRestClient(RestClient.builder()
                .baseUrl(articleBaseUri)
                .requestInterceptor(
                        new OauthClientHttp
                )
                .build()
        );
    }
}
