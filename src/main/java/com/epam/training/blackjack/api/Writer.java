package com.epam.training.blackjack.api;

import com.epam.training.blackjack.model.Card;

public interface Writer {
    void writeMessage(String message);
    void writeCard(Card card);
}
