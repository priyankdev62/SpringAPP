package com.example.SprinProject.DTO;

public class ProductRequestDTO {
    private String searchTerm;

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }
    @Override
    public String toString(){
        return "ProductRequestDTO{"+"searchTerm"+searchTerm+ '\'' +
                '}';
    }
}
