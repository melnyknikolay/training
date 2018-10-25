package com.epam.training.letter.impl;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.junit.Test;

import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsoleWriterTest {

    @Test
    public void write() {
        ByteOutputStream byteOut = new ByteOutputStream();
        PrintStream out = new PrintStream(byteOut);
        ConsoleWriter writer = new ConsoleWriter(out);

        String expected = "expected message";
        writer.write(expected);
        String actual = byteOut.toString();
        assertThat(actual).isEqualTo(expected + "\n");

        byteOut.reset();

        expected = "\n";
        writer.write(expected);
        actual = byteOut.toString();
        assertThat(actual).isEqualTo(expected + "\n");

        byteOut.close();
    }
}