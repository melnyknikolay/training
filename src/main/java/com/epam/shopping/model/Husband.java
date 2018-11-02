package com.epam.shopping.model;

import com.epam.shopping.model.api.Market;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Husband {
    private Set<Market> markets;
    private Set<Product> taskFromWife;

    public Husband() {
        this.markets = new HashSet<>();
        this.taskFromWife = new HashSet<>();
    }

    public Set<Product> getAllProductsList() {
        return markets.stream()
                .flatMap(market -> market.showAssortment().stream())
                .collect(Collectors.toSet());
    }

    public Set<Product> getBoughtProductsList() {
        Set<Product> products = taskFromWife;
        taskFromWife = new HashSet<>();
        return products;
    }

    public void buyProducts(List<String> productNames) {
        productNames.forEach(this::findAndBuyProducts);
    }

    private void findAndBuyProducts(String productName) {
        markets.forEach(market -> {

            Set<String> assortment = market.showAssortment().stream()
                    .map(Product::getName)
                    .collect(Collectors.toSet());

            if (assortment.contains(productName)){
                taskFromWife.add(market.getProduct(productName));
                return;
            }
        });

        findInAdvertisement(productName).ifPresent(mark -> {
            markets.add(mark);
            taskFromWife.add(mark.getProduct(productName));
        });
    }

    private Optional<Market> findInAdvertisement(String productName) {
        return Advertisement.getInstance().findMarketByProductName(productName);
    }
}
