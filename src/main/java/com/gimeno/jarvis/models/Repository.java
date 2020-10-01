package com.gimeno.jarvis.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Repository {

    private List<GroceryProduct> products = new ArrayList<>();

    /* SINGLETON PATTERN */
    private Repository() {
    }

    private static class SingletonHelper {
        private static final Repository INSTANCE = new Repository();
    }

    public static Repository getInstance() {
        return SingletonHelper.INSTANCE;
    }


    public void fetchGroceryProducts() {
        products.addAll(Arrays.asList(
                new GroceryProduct(1234, "Milk", GroceryCategory.DAIRY),
                new GroceryProduct(4321, "Butter", GroceryCategory.DAIRY),
                new GroceryProduct(3412, "Bread", GroceryCategory.BREAD)));
    }

    public Optional<GroceryProduct> searchByBarCode(int barCode) {
        return products.stream()
                .filter(product -> product.hasBarCode(barCode))
                .findAny();
    }

}
