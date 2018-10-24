package com.epam.training.blackjack.model;

public enum Card {
    TWO("Two", 2),
    THREE("Three", 3),
    FOUR("four", 4),
    FIVE("Five", 5),
    SIX("Six", 6),
    SEVEN("Seven", 7),
    EIGHT("Eight", 8),
    NINE("Nine", 9),
    TEN("Ten", 10),
    JACK("Jack", 10),
    QUEEN("Queen", 10),
    KING("King", 10),
    ACE("Ace", 11);

    private String name;
    private int weight;

    Card(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
