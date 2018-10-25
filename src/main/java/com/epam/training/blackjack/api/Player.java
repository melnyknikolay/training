package com.epam.training.blackjack.api;

public interface Player {
    void initializeGame(Card... cards);
    void addCard(Card card);
    boolean goOn();
    int getCurrentWeight();
}
