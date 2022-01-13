package com.aaouad.game.carddraw.service;

import com.aaouad.game.carddraw.model.Card;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;


class CardServiceImplTest {

    private CardServicesImpl cardService = new CardServicesImpl();


    @Test
    @DisplayName("Should serve a Result with Color orders,  Value orders, Random and Sorted hands")
    void drawCardsTest() {
        Comparator<Card> colorComparator = Comparator.comparingInt(card -> this.cardService.getColorOrder().indexOf(card.getColor()));
        Comparator<Card> valuesComparator = Comparator.comparingInt(card -> this.cardService.getValueOrder().indexOf(card.getValue()));

        var cardsResult = this.cardService.drawCards();

        assertThat(cardsResult).isNotNull();
        assertThat(cardsResult.getColorOrder()).isNotNull();
        assertThat(cardsResult.getValueOrder()).isNotNull();
        assertThat(cardsResult.getRandomHand()).isNotNull();
        assertThat(cardsResult.getRandomHand().getCards()).hasSize(10);
        assertThat(cardsResult.getSortedHand()).isNotNull();
        assertThat(cardsResult.getSortedHand().getCards()).hasSize(10);
        assertThat(cardsResult.getSortedHand().getCards()).isSortedAccordingTo(colorComparator.thenComparing(valuesComparator));
    }

}