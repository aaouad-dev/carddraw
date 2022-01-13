package com.aaouad.game.carddraw.utils;

import com.aaouad.game.carddraw.model.Card;
import com.aaouad.game.carddraw.model.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CardUtilsTest {
    @Test
    @DisplayName("Should generate every card once time")
    void generateAllDeckCardsTest() {
        var cards = CardUtils.generateAllCards();
        assertThat(cards).hasSize(52);
        assertThat(cards).containsOnly(
                new Card(1, Color.CARREAU),
                new Card(2, Color.CARREAU),
                new Card(3, Color.CARREAU),
                new Card(4, Color.CARREAU),
                new Card(5, Color.CARREAU),
                new Card(6, Color.CARREAU),
                new Card(7, Color.CARREAU),
                new Card(8, Color.CARREAU),
                new Card(9, Color.CARREAU),
                new Card(10, Color.CARREAU),
                new Card(11, Color.CARREAU),
                new Card(12, Color.CARREAU),
                new Card(13, Color.CARREAU),

                new Card(1, Color.COEUR),
                new Card(2, Color.COEUR),
                new Card(3, Color.COEUR),
                new Card(4, Color.COEUR),
                new Card(5, Color.COEUR),
                new Card(6, Color.COEUR),
                new Card(7, Color.COEUR),
                new Card(8, Color.COEUR),
                new Card(9, Color.COEUR),
                new Card(10, Color.COEUR),
                new Card(11, Color.COEUR),
                new Card(12, Color.COEUR),
                new Card(13, Color.COEUR),

                new Card(1, Color.PIQUE),
                new Card(2, Color.PIQUE),
                new Card(3, Color.PIQUE),
                new Card(4, Color.PIQUE),
                new Card(5, Color.PIQUE),
                new Card(6, Color.PIQUE),
                new Card(7, Color.PIQUE),
                new Card(8, Color.PIQUE),
                new Card(9, Color.PIQUE),
                new Card(10, Color.PIQUE),
                new Card(11, Color.PIQUE),
                new Card(12, Color.PIQUE),
                new Card(13, Color.PIQUE),

                new Card(1, Color.TREFLE),
                new Card(2, Color.TREFLE),
                new Card(3, Color.TREFLE),
                new Card(4, Color.TREFLE),
                new Card(5, Color.TREFLE),
                new Card(6, Color.TREFLE),
                new Card(7, Color.TREFLE),
                new Card(8, Color.TREFLE),
                new Card(9, Color.TREFLE),
                new Card(10, Color.TREFLE),
                new Card(11, Color.TREFLE),
                new Card(12, Color.TREFLE),
                new Card(13, Color.TREFLE)
        );
    }

    @Test
    @DisplayName("should return shuffled 4 colors")
    void colorOrderTest() {
        var colors = CardUtils.generateRandomColors();

        assertThat(colors).hasSize(4);
        assertThat(colors).containsExactlyInAnyOrder(Color.TREFLE, Color.COEUR, Color.CARREAU, Color.PIQUE);
    }


    @Test
    @DisplayName("should return shuffled 13 values")
    void valuesOrderTest() {
        var colorOrder = CardUtils.generateRandomHandValues();

        assertThat(colorOrder).hasSize(13);
        assertThat(colorOrder).allMatch(value -> value >= 1 && value <= 13);
    }

}