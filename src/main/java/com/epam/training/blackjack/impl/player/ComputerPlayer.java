package com.epam.training.blackjack.impl.player;

import java.util.Random;

public class ComputerPlayer extends BasePlayer {

    @Override
    public boolean goOn() {
        int currentWeight = getCurrentWeight();
        if (currentWeight <= 12){
            return true;
        }else if (currentWeight <= 17){
            return new Random().nextBoolean();
        }
        return false;
    }
}
