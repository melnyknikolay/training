package com.epam.training.blackjack.impl;

import com.epam.training.blackjack.model.Card;
import com.epam.training.blackjack.api.Dealer;

import java.util.*;

public class SimpleDealer implements Dealer {
    private final List<Card> cards = new LinkedList<Card>();
    private int position = 0;
    {
        cards.addAll(Arrays.asList(Card.values()));
        cards.addAll(Arrays.asList(Card.values()));
        cards.addAll(Arrays.asList(Card.values()));
        cards.addAll(Arrays.asList(Card.values()));
    }

    @Override
    public void shuffleCards() {
        Collections.shuffle(cards, new Random());
        position = 0;
    }

    @Override
    public Card nextCard() {
        ++position;
        if (position == cards.size()){
            return null;
        }
        return cards.get(position);
    }
}
