package com.example.demo.controller;

import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class ProductController {

    private ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto productDto) {
        ProductDto savedProduct = productService.saveProduct(productDto);
        return new ResponseEntity<>(savedProduct,HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> products = productService.getAllProducts();
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
}
