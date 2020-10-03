package com.gimeno.jarvis.controllers;

import com.gimeno.jarvis.models.Fridge;
import com.gimeno.jarvis.models.GroceryProduct;
import com.gimeno.jarvis.models.dao.Dao;
import com.gimeno.jarvis.models.exceptions.FridgeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FridgeController {

    @Autowired
    private Dao<Fridge> fridgeDao;

    @GetMapping("/fridge/{id}")
    public Fridge getFridge(@PathVariable(value = "id") Long id) {
        return fridgeDao.get(id).orElseThrow(FridgeNotFoundException::new);
    }

    @PostMapping("/fridge/{id}/grocery_product")
    public Fridge addProductToFridge(@PathVariable(value = "id") Long id, @RequestBody GroceryProduct newProduct) {
        Fridge fridge = fridgeDao.get(id).orElseThrow(FridgeNotFoundException::new);
        fridge.addGroceryProduct(newProduct);
        fridgeDao.update(fridge);
        return fridge;
    }

    @DeleteMapping("/fridge/{id}/grocery_product")
    public Fridge removeProductFromFridge(@PathVariable(value = "id") Long id, @RequestBody GroceryProduct product) {
        Fridge fridge = fridgeDao.get(id).orElseThrow(FridgeNotFoundException::new);
        fridge.removeGroceryProduct(product);
        fridgeDao.update(fridge);
        return fridge;
    }

}
