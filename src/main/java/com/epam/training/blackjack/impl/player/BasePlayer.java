package com.epam.training.blackjack.impl.player;

import com.epam.training.blackjack.api.Player;
import com.epam.training.blackjack.model.Card;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public abstract class BasePlayer implements Player {
    protected final List<Card> cards = new LinkedList<>();

    @Override
    public void initializeGame(Card... cards) {
        this.cards.addAll(Arrays.asList(cards));
    }

    @Override
    public void addCard(Card card) {
        this.cards.add(card);
    }

    @Override
    public int getCurrentWeight() {
        return cards.stream().mapToInt(Card::getWeight).reduce(0, ((left, right) -> left + right));
    }
}
