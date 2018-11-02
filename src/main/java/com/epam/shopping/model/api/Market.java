package com.epam.shopping.model.api;

import com.epam.shopping.model.Product;

import java.util.Set;

public interface Market {
    Set<Product> showAssortment();
    Product getProduct(String productName);
}
