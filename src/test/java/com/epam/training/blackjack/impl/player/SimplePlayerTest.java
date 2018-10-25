package com.epam.training.blackjack.impl.player;

import com.epam.training.blackjack.api.Reader;
import com.epam.training.blackjack.api.Writer;
import com.epam.training.blackjack.impl.ConsoleWriter;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SimplePlayerTest extends BasePlayerTest{

    @Mock
    private Reader reader;
    private Writer writer = new ConsoleWriter(System.out);

    @Override
    public void init() {
        player = new SimplePlayer(reader, writer);
    }

    @Test
    public void goOn() {
        when(reader.readCommand()).thenReturn("y").thenReturn("y").thenReturn("any");
        assertTrue(player.goOn());
        assertTrue(player.goOn());
        assertFalse(player.goOn());
    }
}