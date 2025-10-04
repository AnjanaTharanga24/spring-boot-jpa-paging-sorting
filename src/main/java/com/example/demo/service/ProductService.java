package com.example.demo.service;

import com.example.demo.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto saveProduct(ProductDto productDto);
    List<ProductDto> getAllProducts();
}
