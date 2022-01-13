package com.aaouad.game.carddraw.utils;

import com.aaouad.game.carddraw.model.Card;
import com.aaouad.game.carddraw.model.Color;
import lombok.experimental.UtilityClass;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.aaouad.game.carddraw.constants.CardConstants.*;

@UtilityClass
public class CardUtils {

    private static final Random RANDOM = new Random();

    public static List<Card> generateAllCards() {
        return IntStream.range(1, 14)
                .mapToObj(value -> List.of(
                        new Card(value, Color.CARREAU),
                        new Card(value, Color.TREFLE),
                        new Card(value, Color.PIQUE),
                        new Card(value, Color.COEUR)
                ))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public static List<Color> generateRandomColors() {
        var colors = Arrays.asList(Color.values());
        Collections.shuffle(colors);
        return colors;
    }

    public static List<Integer> generateRandomHandValues() {
        var givenList = IntStream.range(MIN_CARD_VALUE, MAX_CARD_VALUE)
                .mapToObj(i -> i)
                .collect(Collectors.toList());
        Collections.shuffle(givenList);
        return givenList;
    }
}
