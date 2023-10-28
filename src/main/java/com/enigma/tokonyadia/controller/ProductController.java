package com.enigma.tokonyadia.controller;

import com.enigma.tokonyadia.entity.Product;
import com.enigma.tokonyadia.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public Product createNewProduct(@RequestBody Product product){
        return productService.create(product);
    }

}
