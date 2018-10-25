package com.epam.training.blackjack.impl;

import com.epam.training.blackjack.api.Card;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleWriterTest {

    @Mock
    private Card card;
    private ByteOutputStream out = new ByteOutputStream();
    private ConsoleWriter writer = new ConsoleWriter(new PrintStream(out));

    @After
    public void clear(){
        out.reset();
    }


    @Test
    public void writeMessage() {
        String expected = "expected message";
        writer.writeMessage(expected);
        String actual = out.toString();

        assertThat(actual).isEqualTo(expected + "\n");
    }

    @Test
    public void writeCard() {
        String expected = "Card";
        when(card.toString()).thenReturn(expected);
        writer.writeCard(card);
        String actual = out.toString();

        assertThat(actual).isEqualTo(expected + "\n");

    }
}