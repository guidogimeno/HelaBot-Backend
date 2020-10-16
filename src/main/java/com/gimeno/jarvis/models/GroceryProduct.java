package com.gimeno.jarvis.models;

import javax.persistence.*;

@Entity
@Table(name = "grocery_products")
public class GroceryProduct {

    /*@Id
    @GeneratedValue
    private Long id;*/

    @Id
    @Column(name = "barcode", unique = true)
    private long barCode;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    private GroceryCategory category;

    public GroceryProduct() {
    }

    public GroceryProduct(long barCode, String name, GroceryCategory category) {
        this.barCode = barCode;
        this.name = name;
        this.category = category;
    }

    public long getBarCode() {
        return this.barCode;
    }

    public String getName() {
        return name;
    }

    public GroceryCategory getCategory() {
        return category;
    }

    public boolean hasSameBarCode(GroceryProduct product) {
        return hasBarCode(product.getBarCode());
    }

    public boolean hasBarCode(long barCode) {
        return getBarCode() == barCode;
    }

}
