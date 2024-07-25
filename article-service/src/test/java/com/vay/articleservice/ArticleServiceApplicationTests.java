package com.vay.articleservice;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// TODO: add test container and insert data into it

//@Transactional
@SpringBootTest
@AutoConfigureMockMvc
class ArticleServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("Test add article")
    public void addArticleTest() throws Exception {
        String article = """
                {
                	"title": "",
                	"content": ""
                }""";

        mockMvc.perform(post("/api/v1/article")
                        .content(article)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("Test delete article")
    public void deleteArticleTest() throws Exception {
        String id = "0";

        mockMvc.perform(delete("/api/v1/article/{id}", id))
.andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("Test get article")
    public void getArticleTest() throws Exception {
        String id = "0";

        mockMvc.perform(get("/api/v1/article/{id}", id))
.andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("Test get articles")
    public void getArticlesTest() throws Exception {
        mockMvc.perform(get("/api/v1/article"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
