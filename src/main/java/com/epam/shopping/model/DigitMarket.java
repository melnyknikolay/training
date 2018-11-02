package com.epam.shopping.model;

import com.epam.shopping.model.api.Market;

import java.util.HashSet;
import java.util.Set;

public class DigitMarket implements Market {
    private static Set<Product> products = new HashSet<>();

    static {
        products.add(new Product("Sony", 300));
        products.add(new Product("Apple", 400));
        products.add(new Product("Siemens", 50));
        products.add(new Product("Dell", 400));
        products.add(new Product("LG", 200));
    }
    public static void addProduct(Product product){
        products.add(product);
    }

    @Override
    public Set<Product> showAssortment() {
        return DigitMarket.products;
    }

    @Override
    public Product getProduct(String productName) {
        return products.stream().filter(product -> product.getName().equals(productName)).findFirst().get();
    }
}
