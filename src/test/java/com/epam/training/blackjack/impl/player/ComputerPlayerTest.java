package com.epam.training.blackjack.impl.player;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ComputerPlayerTest extends BasePlayerTest {

    @Override
    public void init() {
        player = new ComputerPlayer();
    }

    @Test
    public void goOn() {
        when(card.getWeight()).thenReturn(5).thenReturn(5).thenReturn(5).thenReturn(5);
        player.addCard(card);
        player.addCard(card);

        assertTrue(player.goOn());

        player.addCard(card);
        player.addCard(card);

        assertFalse(player.goOn());
    }
}