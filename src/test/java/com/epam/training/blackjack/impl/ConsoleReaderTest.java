package com.epam.training.blackjack.impl;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.junit.Test;

import java.io.InputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ConsoleReaderTest {

    @Test
    public void readCommand() {
        String expected = "expected command";
        byte[] expectedByteArray = (expected + "\n").getBytes();
        InputStream in = new ByteInputStream(expectedByteArray, expectedByteArray.length);
        ConsoleReader reader = new ConsoleReader(in);
        String actual = reader.readCommand();
        assertThat(actual).isEqualTo(expected);
    }
}