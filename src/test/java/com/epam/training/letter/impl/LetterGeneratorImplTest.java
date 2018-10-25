package com.epam.training.letter.impl;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LetterGeneratorImplTest {

    @Test
    public void getRandomLetter() {

        LetterGeneratorImpl generator = new LetterGeneratorImpl();

        Map<Character, Integer> statistics = new HashMap<>();

        char actual;
        for (int i = 0; i < 10000; i++){
            actual = generator.getRandomLetter();
            assertThat(actual).isBetween('a', 'z');
            statistics.merge(actual, 1, (ov, nv) -> ov + nv);
        }

        for (Map.Entry<Character, Integer> pair: statistics.entrySet()){
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }


    }
}