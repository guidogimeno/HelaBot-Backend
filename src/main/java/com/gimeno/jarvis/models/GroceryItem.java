package com.gimeno.jarvis.models;

public class GroceryItem {

    private GroceryProduct product;
    private int quantity = 1;

    public GroceryItem(GroceryProduct product) {
        this.product = product;
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
