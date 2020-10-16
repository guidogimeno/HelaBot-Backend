package com.gimeno.jarvis.models.service;

import com.gimeno.jarvis.models.GroceryProduct;

import java.util.List;

public interface IGroceryProductService {
    GroceryProduct get(long id);

    List<GroceryProduct> getAll();

    void save(GroceryProduct fridge);

    void delete(long id);

    GroceryProduct findByBarCode(long barCode);
}
