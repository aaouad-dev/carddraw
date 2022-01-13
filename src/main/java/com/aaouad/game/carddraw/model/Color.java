package com.aaouad.game.carddraw.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Color {
    TREFLE("Trèfle"), CARREAU("Carreau"), COEUR("Coeur"), PIQUE("Pique");
    private final String name;
}
