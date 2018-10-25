package com.epam.training.letter;

import com.epam.training.letter.api.LetterGenerator;
import com.epam.training.letter.api.Reader;
import com.epam.training.letter.api.Writer;
import com.epam.training.letter.impl.ConsoleWriter;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LetterTest {

    @Mock
    private Reader reader;

    private Writer writer = new ConsoleWriter(System.out);

    @Mock
    private LetterGenerator letterGenerator;

    private Letter game;

    @Before
    public void initClass(){
        when(reader.readLetter()).thenReturn('a').thenReturn('g').thenReturn('z').thenReturn('k');
        when(letterGenerator.getRandomLetter()).thenReturn('k');

        game = new Letter(reader, writer, letterGenerator);
    }

    @Test
    public void start() {

         game.start();

         verify(letterGenerator, times(1)).getRandomLetter();
         verifyNoMoreInteractions(letterGenerator);

         verify(reader, times(4)).readLetter();
         verifyNoMoreInteractions(reader);


    }
}