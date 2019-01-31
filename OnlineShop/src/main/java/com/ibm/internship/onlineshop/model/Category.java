package com.ibm.internship.onlineshop.model;

public class Category {

    private int categoryCode;
    private String name;

    public Category() {}

    public Category(int categoryCode, String name) {
        this.categoryCode = categoryCode;
        this.name = name;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}