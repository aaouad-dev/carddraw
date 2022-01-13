package com.aaouad.game.carddraw.controller;

import com.aaouad.game.carddraw.model.CardsResult;
import com.aaouad.game.carddraw.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class CardRestController {
    private final CardService cardService;

    @GetMapping(value = "/cards")
    public CardsResult drawCards() {
        return cardService.drawCards();
    }

}
