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
        //String str ="stock location:" + requestDTO/getSearchLocation();
        Map<String, Object> productResponse = searchClient.getProducts(requestDTO.getSearchTerm());
        List<Product> productList = new ArrayList<Product>();
        List<Map<String, Object>> products = (List<Map<String, Object>>) (((Map<String, Object>) (productResponse.get("response"))).get("docs"));
        for (Map<String, Object> product : products) {
            Product p1 = new Product();
            p1.setDescription((String) product.get("description"));
            
            p1.setInstock((int) product.get("isInStock")==1?true:false);
            p1.setSalePrice(((Double) product.get("salePrice")).intValue());
            p1.setTitle((String) product.get("name"));
            productList.add(p1);
        }
        //Map<String, Object>  = searchClient.getProducts(requestDTO.getSearchTerm());


        Map<String, Object> locationResponse = searchClient.getProducts("q="+requestDTO.getSearchLocation());
        List<Product> productList2 = new ArrayList<Product>();
        List<Map<String, Object>> location = (List<Map<String, Object>>) (((Map<String, Object>) (productResponse.get("response"))).get("docs"));
        for (Map<String, Object> product : location) {
            Product p1 = new Product();
            p1.setDescription((String) product.get("description"));

            p1.setInstock((int) product.get("isInStock")==1?true:false);
            p1.setSalePrice(((Double) product.get("salePrice")).intValue());
            p1.setTitle((String) product.get("name"));
            productList2.add(p1);
        }




        ProductResponseDTO responseDTO = new ProductResponseDTO();
        responseDTO.setProductList(productList);
        responseDTO.setLocationBasedProduct(productList2);
        return responseDTO;
    }

    }
