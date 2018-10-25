package com.epam.training.blackjack;

import com.epam.training.blackjack.api.*;
import com.epam.training.blackjack.impl.ConsoleReader;
import com.epam.training.blackjack.impl.ConsoleWriter;
import com.epam.training.blackjack.impl.player.SimplePlayer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BlackJackTest {

    private Writer writer = new ConsoleWriter(System.out);
    @Mock
    private Reader reader;
    @Mock
    private Dealer dealer;
    @Mock
    private Card card;
    private SimplePlayer player;

    @Before
    public void init(){
        player = new SimplePlayer(reader, writer);
    }

    @Test
    public void start() {
        when(dealer.nextCard()).thenReturn(card);
        when(card.getWeight()).thenReturn(3);

        BlackJack game = new BlackJack(dealer, writer);
        game.joinGame(player);

        when(reader.readCommand()).thenReturn("y");
        game.start();
        verify(dealer, times(1)).shuffleCards();
        verify(dealer, atLeast(10)).nextCard();

        System.out.println("\n!!!!!!!!!!!!!!!!NEW GAME!!!!!!!!!!!!!!!!\n");

        when(reader.readCommand()).thenReturn("any");
        game.start();
        verify(dealer, times(2)).shuffleCards();
        verify(dealer, atLeast(15)).nextCard();
    }
}