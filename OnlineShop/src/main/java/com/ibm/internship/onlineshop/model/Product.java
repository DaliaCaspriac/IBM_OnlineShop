package com.ibm.internship.onlineshop.model;

public class Product {

    private int productCode;
    private String name;
    private String description;
    private String color;
    private String dimension;
    private double weight;
    private double price;
    private int quantity;
    private int categoryCode;

    public Product() {}

    public Product(int productCode, String name, String description,
                   String color, String dimension, double weight,
                   double price, int quantity, int categoryCode) {
        this.productCode = productCode;
        this.name = name;
        this.description = description;
        this.color = color;
        this.dimension = dimension;
        this.weight = weight;
        this.price = price;
        this.quantity = quantity;
        this.categoryCode = categoryCode;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }
}