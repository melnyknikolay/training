package com.epam.training.blackjack.impl.player;

import com.epam.training.blackjack.api.Card;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.intThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BasePlayerTest {

    @Mock
    Card card;

    BasePlayer player;

    @Before
    public void init() {
        player = new BasePlayer() {
            @Override
            public boolean goOn() {
                return false;
            }
        };
    }

    @Test
    public void getCurrentWeight() {
        when(card.getWeight()).thenReturn(5).thenReturn(3).thenReturn(7);
        player.addCard(card);
        player.addCard(card);
        player.addCard(card);
        int expected = 5 + 3 + 7;
        int actual = player.getCurrentWeight();

        assertEquals(expected, actual);
    }
}