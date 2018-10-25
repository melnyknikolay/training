package com.epam.training.letter.impl;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class ConsoleReaderTest {

    @Test
    public void readLetter() {
        char expected = 'a';
        byte[] expectedByteArray = (expected + "\n").getBytes();
        InputStream in = new ByteInputStream(expectedByteArray, expectedByteArray.length);
        ConsoleReader reader = new ConsoleReader(in);
        char actual = reader.readLetter();
        assertEquals(expected, actual);
    }

    @Test
    public void readString() {
        char expected = 0;
        byte[] expectedByteArray = ("fTgsi68://kl").getBytes();
        InputStream in = new ByteInputStream(expectedByteArray, expectedByteArray.length);
        ConsoleReader reader = new ConsoleReader(in);
        char actual = reader.readLetter();
        assertEquals(expected, actual);
    }

    @Test
    public void readDigit() {
        char expected = 0;
        byte[] expectedByteArray = ('5' + "\n").getBytes();
        InputStream in = new ByteInputStream(expectedByteArray, expectedByteArray.length);
        ConsoleReader reader = new ConsoleReader(in);
        char actual = reader.readLetter();
        assertEquals(expected, actual);
    }

    @Test
    public void readOtherChars() {
        char expected = 0;
        byte[] expectedByteArray = ('^' + "\n").getBytes();
        InputStream in = new ByteInputStream(expectedByteArray, expectedByteArray.length);
        ConsoleReader reader = new ConsoleReader(in);
        char actual = reader.readLetter();
        assertEquals(expected, actual);
    }
}