package com.example.SprinProject.DTO;

public class Product {
    private boolean instock;

    public boolean isInstock() {
        return instock;
    }

    public void setInstock(boolean instock) {
        this.instock = instock;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private Double salePrice;
    private String description;
    private String title;

}
