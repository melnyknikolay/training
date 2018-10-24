package com.epam.training.blackjack;

import com.epam.training.blackjack.api.Dealer;
import com.epam.training.blackjack.api.Player;
import com.epam.training.blackjack.api.Writer;
import com.epam.training.blackjack.impl.player.ComputerPlayer;

public class BlackJack {
    private final Dealer dealer;
    private final Writer writer;
    private Player player;
    private final Player opponent;
    private boolean isPlayerContinues = true;
    private boolean isOpponentContinues = true;

    public BlackJack(Dealer dealer, Writer writer) {
        this.dealer = dealer;
        this.writer = writer;
        this.opponent = new ComputerPlayer();
    }

    public void joinGame(Player player) {
        this.player = player;
    }

    public void start() {
        if (checkPlayer()) {
            writer.writeMessage("The Game started\n");
            dealer.shuffleCards();

            initialize();

            while (!checkWinner()) {
                askPlayers();
                giveCards();
            }
        }
    }

    private void initialize() {
        player.initializeGame(dealer.nextCard(), dealer.nextCard());
        opponent.initializeGame(dealer.nextCard(), dealer.nextCard());
    }

    private void askPlayers() {
        if (isPlayerContinues) {
            isPlayerContinues = player.goOn();
        }
        if (isOpponentContinues) {
            isOpponentContinues = opponent.goOn();
        }
    }

    private boolean checkWinner() {
        int playerCurrentWeight = player.getCurrentWeight();
        int opponentCurrentWeight = opponent.getCurrentWeight();

        if (playerCurrentWeight > 21 && opponentCurrentWeight > 21) {
            writer.writeMessage(playerCurrentWeight < opponentCurrentWeight ? "Player win!!! Total: " + playerCurrentWeight : "Player lost!!!");
            return true;
        } else if (playerCurrentWeight == 21 || opponentCurrentWeight > 21) {
            writer.writeMessage("Player win!!! Total: " + playerCurrentWeight);
            return true;
        } else if (playerCurrentWeight > 21 || opponentCurrentWeight == 21) {
            writer.writeMessage("Player lost!!!");
            return true;
        } else if (!isPlayerContinues && !isOpponentContinues) {
            writer.writeMessage(playerCurrentWeight < opponentCurrentWeight ? "Player win!!! Total: " + playerCurrentWeight : "Player lost!!!");
            return true;
        }
        return false;
    }

    private void giveCards() {
        if (isPlayerContinues) {
            player.addCard(dealer.nextCard());
        }

        if (isOpponentContinues) {
            opponent.addCard(dealer.nextCard());
        }
    }

    private boolean checkPlayer() {
        if (player == null) {
            writer.writeMessage("Player does`t exist");
            return false;
        }
        return true;
    }
}
