package com.gimeno.jarvis.controllers;

import com.gimeno.jarvis.models.GroceryProduct;
import com.gimeno.jarvis.models.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JsonController {

    @Autowired
    private Dao<GroceryProduct> groceryProductDao;

    @GetMapping("/grocery_products")
    public List<GroceryProduct> getGroceryProducts() {
        return  groceryProductDao.getAll();
    }

}
