package com.epam.training.letter.impl;

import com.epam.training.letter.api.Reader;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleReader implements Reader {
    private final InputStream in;

    public ConsoleReader(InputStream in) {
        this.in = in;
    }

    @Override
    public char readLetter() {
        Scanner scanner = new Scanner(in);
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            if (line.length() == 1 && Character.isLetter(line.charAt(0))){
                return Character.toLowerCase(line.charAt(0));
            }else {
                System.out.println("Enter one letter!");
            }

        }
        return 0;
    }
}
