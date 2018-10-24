package com.epam.training.blackjack.impl.player;

import com.epam.training.blackjack.api.Reader;
import com.epam.training.blackjack.api.Writer;

public class SimplePlayer extends BasePlayer {
    private final Reader reader;
    private final Writer writer;

    public SimplePlayer(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public boolean goOn() {
        writer.writeMessage("Cards: ");
        cards.forEach(writer::writeCard);
        writer.writeMessage("Total: " + getCurrentWeight());
        writer.writeMessage("Get new card?");
        writer.writeMessage("Press \"y\" for \"yes\"");
        writer.writeMessage("any other for \"no\"");
        String command = reader.readCommand();
        return "y".equals(command);
    }
}
