package com.gimeno.jarvis.controllers;

import com.gimeno.jarvis.models.GroceryProduct;
import com.gimeno.jarvis.models.service.IFridgeService;
import com.gimeno.jarvis.models.service.IGroceryProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroceryProductController {

    @Autowired
    private IGroceryProductService groceryProductService;

    @GetMapping("/grocery_products")
    public List<GroceryProduct> getGroceryProducts() {
        return  groceryProductService.getAll();
    }

    @GetMapping("grocery_product/{barCode}")
    public ResponseEntity<?> getGroceryProduct(@PathVariable(value = "barCode") Long barCode) {
        GroceryProduct grocerProduct = groceryProductService.findByBarCode(barCode);
        if(grocerProduct == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(grocerProduct, HttpStatus.OK);
    }

}
