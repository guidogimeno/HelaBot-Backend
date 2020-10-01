package com.gimeno.jarvis.models;

import com.gimeno.jarvis.models.exceptions.GroceryItemNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Fridge {

    private List<GroceryItem> groceryItems = new ArrayList<>();

    public void addGroceryProduct(GroceryProduct newProduct) {
        Optional<GroceryItem> item = findItem(newProduct);

        if (item.isPresent()) {
            item.get().increaseQuantity();
        } else {
            groceryItems.add(new GroceryItem(newProduct));
        }
    }

    public void removeGroceryProduct(GroceryProduct product) {
        GroceryItem item = findItem(product).orElseThrow(GroceryItemNotFoundException::new);

        if(item.getQuantity() == 1) {
            groceryItems.remove(item);
        } else {
            item.decreaseQuantity();
        }
    }

    public Optional<GroceryItem> findItem(GroceryProduct product) {
        return groceryItems.stream()
                .filter(i -> i.hasProduct(product))
                .findAny();
    }

}
