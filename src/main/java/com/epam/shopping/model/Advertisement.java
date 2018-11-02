package com.epam.shopping.model;

import com.epam.shopping.model.api.Market;

import java.util.*;
import java.util.stream.Collectors;

public class Advertisement {
    private final static Advertisement advertisement = new Advertisement();

    private Set<Market> markets;
    private final Random random = new Random();

    private Advertisement() {
        markets = new HashSet<>();
    }

    public static Advertisement getInstance(){
        return advertisement;
    }

    public void addMarket(Market... market) {
        this.markets.addAll(Arrays.asList(market));
    }

    public List<String> watchTV() {
        return markets.stream()
                .flatMap(market -> market.showAssortment().stream())
                .filter(product -> random.nextBoolean())
                .map(Product::getName)
                .collect(Collectors.toList());
    }

    public Optional<Market> findMarketByProductName(String productName) {
        return markets.stream()
                .filter(market -> market.showAssortment().stream().map(Product::getName).collect(Collectors.toList()).contains(productName))
                .findFirst();

    }
}
