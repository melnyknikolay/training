package com.epam.training.blackjack.impl;

import com.epam.training.blackjack.api.Reader;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleReader implements Reader {
    private final InputStream in;

    public ConsoleReader(InputStream in) {
        this.in = in;
    }

    @Override
    public String readCommand() {
        Scanner scanner = new Scanner(in);
        return scanner.nextLine();
    }
}
