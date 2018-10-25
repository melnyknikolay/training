package com.epam.training.blackjack.impl;


import com.epam.training.blackjack.api.Card;
import com.epam.training.blackjack.api.Writer;

import java.io.PrintStream;

public class ConsoleWriter implements Writer {
    private final PrintStream out;

    public ConsoleWriter(PrintStream out) {
        this.out = out;
    }

    @Override
    public void writeMessage(String message) {
        out.println(message);
    }

    @Override
    public void writeCard(Card card) {
        out.println(card);
    }
}
