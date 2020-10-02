package com.gimeno.jarvis.controllers;

import com.gimeno.jarvis.models.Fridge;
import com.gimeno.jarvis.models.GroceryCategory;
import com.gimeno.jarvis.models.GroceryProduct;
import com.gimeno.jarvis.models.dao.Dao;
import com.gimeno.jarvis.models.exceptions.FridgeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FridgeController {

    @Autowired
    private Dao<GroceryProduct> groceryProductDao;

    @Autowired
    private Dao<Fridge> fridgeDao;

    @GetMapping("/grocery_products")
    public List<GroceryProduct> getGroceryProducts() {
        createObjects();
        return  groceryProductDao.getAll();
    }

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

    //TODO: Eliminate this which was created with testing purpose
    private void createObjects() {
        GroceryProduct milk = new GroceryProduct(1234, "Milk", GroceryCategory.DAIRY);
        GroceryProduct butter = new GroceryProduct(4321, "Butter", GroceryCategory.DAIRY);
        GroceryProduct bread = new GroceryProduct(3412, "Bread", GroceryCategory.BREAD);

        Fridge fridge = new Fridge();

        // Milks
        for(int i = 1; i <= 4; i++) {
            fridge.addGroceryProduct(milk);
        }

        //Bread
        for(int i = 1; i <= 10; i++) {
            fridge.addGroceryProduct(bread);
        }

        //Ketchup
        fridge.addGroceryProduct(butter);

        fridgeDao.save(fridge);
    }

}
