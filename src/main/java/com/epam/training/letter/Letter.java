package com.epam.training.letter;

import com.epam.training.letter.api.LetterGenerator;
import com.epam.training.letter.api.Reader;
import com.epam.training.letter.api.Writer;

public class Letter {
    private final Reader reader;
    private final Writer writer;
    private final LetterGenerator letterGenerator;

    public Letter(Reader reader, Writer writer, LetterGenerator letterGenerator) {
        this.reader = reader;
        this.writer = writer;
        this.letterGenerator = letterGenerator;
    }

    public void start() {
        int count = 0;
        char randomLetter = letterGenerator.getRandomLetter();
        while (true) {
            ++count;
            writer.write("Enter a letter");
            char letter = reader.readLetter();
            int compare = compare(letter, randomLetter);
            switch (compare) {
                case 1:
                    writer.write("Too high!");
                    continue;
                case -1:
                    writer.write("Too low!");
                    continue;
                default:
                    writer.write("You win. Quantity: " + count);
                    break;
            }
            break;
        }
    }

    private int compare(char letter, char randomLetter) {
        return Integer.compare(letter - randomLetter, 0);
    }
}
