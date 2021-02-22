package com.example.SprinProject.Service;

import com.example.SprinProject.DTO.ProductRequestDTO;
import com.example.SprinProject.DTO.ProductResponseDTO;

public interface SearchService {
    ProductResponseDTO getProducts(ProductRequestDTO requestDTO);



}
