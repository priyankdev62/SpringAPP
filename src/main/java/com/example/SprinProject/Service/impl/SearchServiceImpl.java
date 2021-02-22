package com.example.SprinProject.Service.impl;

import com.example.SprinProject.DTO.Product;
import com.example.SprinProject.DTO.ProductRequestDTO;
import com.example.SprinProject.DTO.ProductResponseDTO;
import com.example.SprinProject.Service.SearchService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service
public class SearchServiceImpl implements SearchService {
    public ProductResponseDTO getProducts(ProductRequestDTO requestDTO){
            ProductResponseDTO responseDTO = new ProductResponseDTO();
            Product product1= new Product();
            product1.setTitle("Smartphone");
            product1.setInstock(true);
            product1.setSalePrice(12000);
            product1.setDescription("xiaomi note pro");
            responseDTO.setProductList(Arrays.asList(product1));
            return responseDTO;

    }

}
