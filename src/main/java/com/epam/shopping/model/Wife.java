package com.epam.shopping.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Wife {
    private final Husband husband;
    private List<String> productNames;

    public Wife(Husband husband) {
        this.husband = husband;
        productNames = new ArrayList<>();
    }

    public void setProducts(List<String> productNames) {
        this.productNames = productNames;
    }

    public void giveTaskToHusband(){
        husband.buyProducts(productNames);

        System.out.println("Total list:");
        husband.getAllProductsList().forEach(System.out::println);

        System.out.println("\nBought:");
        Set<Product> boughtProductsList = husband.getBoughtProductsList();
        boughtProductsList.forEach(product -> {
            productNames.remove(product.getName());
            System.out.println(product);
        });
        System.out.println("Total price: " + boughtProductsList.stream().mapToInt(Product::getPrice).sum());
    }

}
