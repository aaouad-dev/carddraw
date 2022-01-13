package com.aaouad.game.carddraw.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CardsResult {
    private List<Color> colorOrder;
    private List<Integer> valueOrder;
    private Hand randomHand;
    private Hand sortedHand;
}
