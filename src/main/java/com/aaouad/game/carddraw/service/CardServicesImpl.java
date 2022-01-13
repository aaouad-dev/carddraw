package com.aaouad.game.carddraw.service;

import com.aaouad.game.carddraw.model.Card;
import com.aaouad.game.carddraw.model.CardsResult;
import com.aaouad.game.carddraw.model.Color;
import com.aaouad.game.carddraw.model.Hand;
import com.aaouad.game.carddraw.utils.CardUtils;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.aaouad.game.carddraw.constants.CardConstants.HAND_SIZE;

@Service
@Getter
public class CardServicesImpl implements CardService {

    private List<Color> colorOrder;
    private List<Integer> valueOrder;

    @Override
    public CardsResult drawCards() {
        this.colorOrder = CardUtils.generateRandomColors();
        this.valueOrder = CardUtils.generateRandomHandValues();
        var shuffledCards = this.getShuffledCards();
        var sortedCards = this.sortCards(shuffledCards);
        return new CardsResult(this.colorOrder, this.valueOrder, new Hand(shuffledCards), new Hand(sortedCards));
    }


    private List<Card> getShuffledCards() {
        var cards = CardUtils.generateAllCards();
        Collections.shuffle(cards);
        return cards.stream().limit(HAND_SIZE).collect(Collectors.toList());
    }

    private List<Card> sortCards(Collection<Card> shuffledCards) {
        return shuffledCards.stream().sorted(comparator()).collect(Collectors.toList());
    }

    private Comparator<Card> comparator() {
        Comparator<Card> colorComparator = Comparator.comparingInt(card -> this.colorOrder.indexOf(card.getColor()));
        Comparator<Card> valuesComparator = Comparator.comparingInt(card -> this.valueOrder.indexOf(card.getValue()));
        return colorComparator.thenComparing(valuesComparator);
    }
}
