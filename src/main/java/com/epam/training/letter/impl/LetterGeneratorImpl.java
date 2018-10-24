package com.epam.training.letter.impl;

import com.epam.training.letter.api.LetterGenerator;

import java.util.Random;

public class LetterGeneratorImpl implements LetterGenerator {
    @Override
    public char getRandomLetter() {
        return (char) (new Random().nextInt(26) + 'a');
    }
}
