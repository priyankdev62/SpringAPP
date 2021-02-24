package com.example.SprinProject.DTO;
import java.util.*;
public class ProductResponseDTO {
    private List<Product> productList;
<<<<<<< Updated upstream
=======
    private List<Product> locationBasedProduct;


    public List<Product> getLocationBasedProduct() {
        return locationBasedProduct;
    }

    public void setLocationBasedProduct(List<Product> locationBasedProduct) {
        this.locationBasedProduct = locationBasedProduct;
    }
>>>>>>> Stashed changes

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void setLoactionBasedProductList(List<Product> locationBasedProductList) {
        this.locationBasedProduct = locationBasedProduct;
    }
}
