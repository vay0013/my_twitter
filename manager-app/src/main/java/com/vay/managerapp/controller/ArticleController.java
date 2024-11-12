package com.vay.managerapp.controller;

import com.vay.managerapp.client.ArticleRestClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleRestClient articleRestClient;

}
