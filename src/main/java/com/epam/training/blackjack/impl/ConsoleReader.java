package com.epam.training.blackjack.impl;

import com.epam.training.blackjack.api.Reader;

import java.util.Scanner;

public class ConsoleReader implements Reader {
    @Override
    public String readCommand() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
