package com.epam.training;

import com.epam.training.letter.Letter;
import com.epam.training.letter.impl.ConsoleReader;
import com.epam.training.letter.impl.ConsoleWriter;
import com.epam.training.letter.impl.LetterGeneratorImpl;

public class LetterGameMain {
    public static void main(String[] args) {
        Letter game = new Letter(new ConsoleReader(System.in), new ConsoleWriter(System.out), new LetterGeneratorImpl());
        game.start();
    }

}
