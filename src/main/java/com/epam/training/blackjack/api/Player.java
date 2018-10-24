package com.epam.training.blackjack.api;

import com.epam.training.blackjack.model.Card;

public interface Player {
    void initializeGame(Card... cards);
    void addCard(Card card);
    boolean goOn();
    int getCurrentWeight();
}
