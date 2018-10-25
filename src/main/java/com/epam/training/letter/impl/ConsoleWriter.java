package com.epam.training.letter.impl;

import com.epam.training.letter.api.Writer;

import java.io.PrintStream;

public class ConsoleWriter implements Writer {
    private final PrintStream out;

    public ConsoleWriter(PrintStream out) {
        this.out = out;
    }

    @Override
    public void write(String message) {
        out.println(message);
    }
}
