package com.aaouad.game.carddraw.controller;

import com.aaouad.game.carddraw.model.CardsResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CardRestControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    @DisplayName("should return 200 and valid response body")
    void serveHand200() throws Exception {
        mockMvc.perform(get("/cards")).andExpect(status().isOk())
                .andExpect(result -> {
                    var gameId = result.getResponse().getContentAsString();
                    mockMvc.perform(get("/cards")).andExpect(status().isOk())
                            .andExpect(content -> {
                                var cardsResult = objectMapper.readValue(content.getResponse().getContentAsString(), CardsResult.class);
                                assertThat(cardsResult).isNotNull();
                                assertThat(cardsResult.getColorOrder()).isNotNull();
                                assertThat(cardsResult.getColorOrder()).isNotEmpty();
                                assertThat(cardsResult.getValueOrder()).isNotNull();
                                assertThat(cardsResult.getValueOrder()).isNotEmpty();
                                assertThat(cardsResult.getRandomHand()).isNotNull();
                                assertThat(cardsResult.getRandomHand().getCards()).isNotNull();
                                assertThat(cardsResult.getRandomHand().getCards()).isNotEmpty();
                                assertThat(cardsResult.getSortedHand()).isNotNull();
                                assertThat(cardsResult.getSortedHand().getCards()).isNotNull();
                                assertThat(cardsResult.getSortedHand().getCards()).isNotEmpty();
                            });
                });
    }

}
