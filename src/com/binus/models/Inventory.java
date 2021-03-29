package com.binus.models;

public class Inventory {
    private String id;
    private String name;
    private Integer price;
    private Integer stock;

    public Inventory() {
    }

    public Inventory(String id, String name, Integer price, Integer stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public boolean getIdConstraint() {
        return id.length() == 5;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public boolean getNameConstraint() {
        return name.length() >= 5 && name.length() <= 28;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public boolean getPriceConstraint() {
        return price >= 10000;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public boolean getStockConstraint() {
        return price >= 10;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock;
    }
}
