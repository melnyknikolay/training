package com.epam.training.blackjack.api;

import com.epam.training.blackjack.model.Card;

public interface Dealer {
    void shuffleCards();
    Card nextCard();
}
