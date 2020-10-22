package com.gimeno.jarvis.controllers;

import com.gimeno.jarvis.models.Fridge;
import com.gimeno.jarvis.models.GroceryProduct;
import com.gimeno.jarvis.models.service.IFridgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class FridgeController {

    @Autowired
    private IFridgeService fridgeService;

    @GetMapping("/fridge/{id}")
    public Fridge getFridge(@PathVariable(value = "id") Long id) {
        return fridgeService.get(id);
    }

    @PostMapping("/fridge/{id}/grocery_product")
    public Fridge addProductToFridge(@PathVariable(value = "id") Long id, @RequestBody GroceryProduct newProduct) {
        Fridge fridge = fridgeService.get(id);
        fridge.addGroceryProduct(newProduct);
        fridgeService.save(fridge);
        return fridge;
    }

    @DeleteMapping("/fridge/{id}/grocery_product")
    public Fridge removeProductFromFridge(@PathVariable(value = "id") Long id, @RequestBody GroceryProduct product) {
        Fridge fridge = fridgeService.get(id);
        fridge.removeGroceryProduct(product);
        fridgeService.save(fridge);
        return fridge;
    }

}
