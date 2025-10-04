package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    ProductDto saveProduct(ProductDto productDto);
    List<ProductDto> getAllProducts();
    Page<ProductDto> getAllProducts(Pageable pageable);
}
