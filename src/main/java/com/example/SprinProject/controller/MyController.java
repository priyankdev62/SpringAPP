package com.example.SprinProject.controller;

import com.example.SprinProject.DTO.ProductRequestDTO;
import com.example.SprinProject.DTO.ProductResponseDTO;
import com.example.SprinProject.Service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
   @Autowired
   SearchService searchService;
    @PostMapping(path="/search")
    public ProductResponseDTO searchMethod(@RequestBody ProductRequestDTO request){
        return searchService.getProducts(request);
    }


}
