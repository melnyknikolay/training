package com.epam.training.blackjack.impl;

import com.epam.training.blackjack.api.Card;
import com.epam.training.blackjack.api.Dealer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;


public class SimpleDealerTest {

    private Dealer dealer = new SimpleDealer();
    private Card card;

    @Before
    public void init(){
        dealer.shuffleCards();
    }

    @Test
    public void shuffleCards() {
        List<Card> cardsBefore = new ArrayList<>();
        for (card = dealer.nextCard(); card != null; card = dealer.nextCard()) {
            cardsBefore.add(card);
        }
        dealer.shuffleCards();

        List<Card> cardsAfter = new ArrayList<>();
        for (card = dealer.nextCard(); card != null; card = dealer.nextCard()) {
            cardsAfter.add(card);
        }

        assertThat(cardsAfter).isNotEqualTo(cardsBefore);
    }

    @Test
    public void nextCard() {
        for (int i = 0; i < 52; i++){
            card = dealer.nextCard();
            assertThat(card).isInstanceOf(Card.class);
        }
        card = dealer.nextCard();
        assertNull(card);
    }
}