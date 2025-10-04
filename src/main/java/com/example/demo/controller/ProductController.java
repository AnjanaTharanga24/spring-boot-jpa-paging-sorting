package com.example.demo.controller;

import com.example.demo.dto.ProductDto;
import com.example.demo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/products/paginated")
    public ResponseEntity<Page<ProductDto>> getAllProductsPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ){
        int validatedSize = validatePageSize(size);

        Pageable pageable = PageRequest.of(page, validatedSize);
        Page<ProductDto> products = productService.getAllProducts(pageable);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    private int validatePageSize(int size){
        int[] allowedSizes = {5,10,15,20};
        for(int allowedSize : allowedSizes){
            if(allowedSize == size){
                return size;
            }
        }
        return 5;
    }
}
