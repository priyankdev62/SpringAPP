package com.example.SprinProject.Service.impl;

import com.example.SprinProject.DTO.Product;
import com.example.SprinProject.DTO.ProductRequestDTO;
import com.example.SprinProject.DTO.ProductResponseDTO;
import com.example.SprinProject.Service.SearchService;
import com.example.SprinProject.client.SearchClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)
class SearchServiceImplTest {
    @InjectMocks
    private SearchServiceImpl searchService;
    @Mock
    private SearchClient searchClient;

    @BeforeEach
    public void init()
    {
        MockitoAnnotations.openMocks(this);
    }
    @AfterEach
    public void teardown(){

    }


    @Test
    void getProducts() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> searchTermMockObject = objectMapper.readValue(new
                URL("file:src/test/resources/search.mock"), Map.class);
        Map<String, Object> locationMockObject = objectMapper.readValue(new
                URL("file:src/test/resources/location.mock"), Map.class);

        Mockito.when(searchClient.getProducts("Samsung")).thenReturn(searchTermMockObject);
        Mockito.when(searchClient.getProducts("stockLocation:Jakarta")).thenReturn(locationMockObject);


        ProductRequestDTO requestDTO = new ProductRequestDTO();
        requestDTO.setSearchTerm("Samsung");
        requestDTO.setSearchLocation("Jakarta");
        ProductResponseDTO responseDto = searchService.getProducts(requestDTO);
        assertEquals(responseDto.getProductList().size(), 10);
        assertEquals(responseDto.getLocationBasedProduct().size(), 10);
        Mockito.verify(searchClient).getProducts("Samsung");
        Mockito.verify(searchClient).getProducts("stockLocation:Jakarta");
    }
        @Test
         void testGetProductException() throws IOException{

            ObjectMapper objectMapper = new ObjectMapper();
            Map<String,Object> searchTermMockObject = objectMapper.readValue(new
                    URL("file:src/test/resources/search.mock"),Map.class);
            Map<String,Object> locationMockObject = objectMapper.readValue(new
                    URL("file:src/test/resources/location.mock"),Map.class);

            Mockito.when(searchClient.getProducts("Samsung")).thenReturn(searchTermMockObject);
            Mockito.when(searchClient.getProducts("stockLocation:Jakarta")).thenThrow(NullPointerException.class);


            ProductRequestDTO requestDTO = new ProductRequestDTO();
            requestDTO.setSearchTerm("Samsung");
            requestDTO.setSearchLocation("Jakarta");
            ProductResponseDTO responseDto = searchService.getProducts(requestDTO);
            assertEquals(responseDto.getProductList().size(), 10);
            assertEquals(responseDto.getLocationBasedProduct(),null);
            Mockito.verify(searchClient).getProducts("Samsung");
            Mockito.verify(searchClient).getProducts("stockLocation:Jakarta");
        }

    }
