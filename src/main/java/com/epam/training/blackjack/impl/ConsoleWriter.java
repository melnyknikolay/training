package com.epam.training.blackjack.impl;


import com.epam.training.blackjack.model.Card;
import com.epam.training.blackjack.api.Writer;

public class ConsoleWriter implements Writer {

    @Override
    public void writeMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void writeCard(Card card) {
        System.out.println(card);
    }
}
