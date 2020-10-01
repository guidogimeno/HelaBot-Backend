package com.gimeno.jarvis.models;

import javax.persistence.*;

@Entity
@Table(name = "grocery_products")
public class GroceryProduct {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "barcode", unique = true)
    private int barCode;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    private GroceryCategory category;

    public GroceryProduct() {
    }

    public GroceryProduct(int barCode, String name, GroceryCategory category) {
        this.barCode = barCode;
        this.name = name;
        this.category = category;
    }

    public int getBarCode() {
        return this.barCode;
    }

    public void setBarCode(int barCode) {
        this.barCode = barCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GroceryCategory getCategory() {
        return category;
    }

    public void setCategory(GroceryCategory category) {
        this.category = category;
    }

    public boolean hasSameBarCode(GroceryProduct product) {
        return hasBarCode(product.getBarCode());
    }

    public boolean hasBarCode(int barCode) {
        return getBarCode() == barCode;
    }

}
