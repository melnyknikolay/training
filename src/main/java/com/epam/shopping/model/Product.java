package com.epam.shopping.model;

public class Product {
    private final String name;
    private int price;

    protected Product(String name, int price) {
        this.name = name;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - " + price;
    }

}
