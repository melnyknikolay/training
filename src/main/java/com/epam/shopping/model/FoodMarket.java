package com.epam.shopping.model;

import com.epam.shopping.model.api.Market;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FoodMarket implements Market {
    private static Set<Product> products = new HashSet<>();

    static {
        products.add(new Product("Bread", 10));
        products.add(new Product("Meat", 60));
        products.add(new Product("Egg", 30));
        products.add(new Product("Sausage", 70));
        products.add(new Product("Cheese", 55));
    }
    public static void addProduct(Product product){
        products.add(product);
    }

    @Override
    public Set<Product> showAssortment() {
        return FoodMarket.products;
    }

    @Override
    public Product getProduct(String productName) {
        return products.stream().filter(product -> product.getName().equals(productName)).findFirst().get();
    }
}
