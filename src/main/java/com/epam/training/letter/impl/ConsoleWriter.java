package com.epam.training.letter.impl;

import com.epam.training.letter.api.Writer;

public class ConsoleWriter implements Writer {
    @Override
    public void write(String message) {
        System.out.println(message);
    }
}
