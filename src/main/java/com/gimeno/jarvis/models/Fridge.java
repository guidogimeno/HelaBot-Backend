package com.gimeno.jarvis.models;

import com.gimeno.jarvis.models.exceptions.GroceryItemNotFoundException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
public class Fridge {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GroceryItem> groceryItems = new ArrayList<>();

    public List<GroceryItem> getGroceryItems() {
        return groceryItems;
    }

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

        if (item.getQuantity() == 1) {
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
