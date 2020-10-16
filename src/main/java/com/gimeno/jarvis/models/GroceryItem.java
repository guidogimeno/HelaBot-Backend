package com.gimeno.jarvis.models;

import javax.persistence.*;

@Entity
public class GroceryItem {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    private GroceryProduct product;

    @Column(name = "quantity")
    private int quantity = 1;

    public GroceryItem() {
    }

    public GroceryItem(GroceryProduct product) {
        this.product = product;
    }

    public GroceryItem(GroceryProduct product, int quantity) {
        this(product);
        this.quantity = quantity;
    }

    public GroceryProduct getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean hasSameProduct(GroceryItem item) {
        return getProduct().hasSameBarCode(item.getProduct());
    }

    public boolean hasProduct(GroceryProduct product) {
        return getProduct().hasSameBarCode(product);
    }

    public void increaseQuantity() {
        this.quantity += 1;
    }

    public void decreaseQuantity() {
        this.quantity -= 1;
    }

}
