package com.aaouad.game.carddraw.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import java.util.Map;

@RequiredArgsConstructor
@Getter
public enum CardType {
    AS("AS", "A"), VALET("Valet", "J"), DAME("Dame", "Q"), ROI("Roi", "K"), REGU(Strings.EMPTY, Strings.EMPTY);
    private final String name; 
    private final String symbol;
    private static final Map<Integer, CardType> values = Map.of(1, AS, 11, VALET, 12, DAME, 13, ROI);

    public static CardType valueOf(int value){
        return values.getOrDefault(value, REGU);
    }
}
