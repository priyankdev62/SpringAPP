package com.example.SprinProject.Service.impl;

import com.example.SprinProject.DTO.Product;
import com.example.SprinProject.DTO.ProductRequestDTO;
import com.example.SprinProject.DTO.ProductResponseDTO;
import com.example.SprinProject.Service.SearchService;
import com.example.SprinProject.client.SearchClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private SearchClient searchClient;

    @Override

    public ProductResponseDTO getProducts(ProductRequestDTO requestDTO) {
        Map<String, Object> productResponse = searchClient.getProducts(requestDTO.getSearchTerm());
        List<Product> productList = new ArrayList<Product>();
        List<Map<String, Object>> products = (List<Map<String, Object>>) (((Map<String, Object>) (productResponse.get("response"))).get("docs"));
        for (Map<String, Object> product : products) {
            Product p1 = new Product();
            p1.setDescription((String) product.get("description"));
            
//            p1.setInstock((int) product.get("isInStock"));
//            p1.setSalePrice((double) product.get("salePrice"));
            p1.setTitle((String) product.get("name"));
            productList.add(p1);
        }
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        /*Product product1 = new Product();
        product1.setTitle("Smartphone");
        product1.setInstock(true);
        product1.setSalePrice(15999);
        product1.setDescription("Xiaomi Redmi Note 5 pro");*/
        responseDTO.setProductList(productList);
        return responseDTO;
    }

    }
