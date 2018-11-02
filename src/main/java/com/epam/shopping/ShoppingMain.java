package com.epam.shopping;

import com.epam.shopping.model.*;

public class ShoppingMain {
    public static void main(String[] args) {

        DigitMarket digitMarket = new DigitMarket();
        FoodMarket foodMarket = new FoodMarket();

        Advertisement advertisement = Advertisement.getInstance();
        advertisement.addMarket(digitMarket, foodMarket);

        Husband husband = new Husband();
        Wife wife = new Wife(husband);

        wife.setProducts(advertisement.watchTV());

        wife.giveTaskToHusband();
    }
}
