package org.istad.crud.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.istad.crud.dto.ProductBody;
import org.istad.crud.dto.ProductDto;
import org.istad.crud.service.ProductService;
import org.istad.crud.service.impl.ProductServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getAllProducts() {
        return Map.of("Message","Get All Products",
                "Products",productService.getAllProduct()
                );
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDto getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Integer id) {
        productService.deleteProductById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@Valid @RequestBody ProductBody product) {
        productService.addProduct(product);
        System.out.println("Product added:" + product);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Integer id, @Valid @RequestBody ProductBody product) {
        productService.updateProductById(id, product);
    }

}
