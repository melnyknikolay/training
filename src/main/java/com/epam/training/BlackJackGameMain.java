package com.epam.training;

import com.epam.training.blackjack.BlackJack;
import com.epam.training.blackjack.api.Player;
import com.epam.training.blackjack.impl.ConsoleReader;
import com.epam.training.blackjack.impl.ConsoleWriter;
import com.epam.training.blackjack.impl.SimpleDealer;
import com.epam.training.blackjack.impl.player.SimplePlayer;

public class BlackJackGameMain {
    public static void main(String[] args) {
        Player player = new SimplePlayer(new ConsoleReader(System.in), new ConsoleWriter(System.out));
        BlackJack game = new BlackJack(new SimpleDealer(), new ConsoleWriter(System.out));
        game.joinGame(player);
        game.start();
    }

}
