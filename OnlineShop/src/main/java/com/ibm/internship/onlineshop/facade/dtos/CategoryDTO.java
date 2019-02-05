package com.ibm.internship.onlineshop.facade.dtos;

public class CategoryDTO {

    private int categoryCode;
    private String name;

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
