package org.istad.crud.service;

import org.istad.crud.dto.ProductBody;
import org.istad.crud.dto.ProductDto;

import java.util.List;

public interface ProductService {
    void addProduct(ProductBody productBody);
    List<ProductDto> getAllProduct();
    ProductDto getProductById(Integer id);
    void updateProductById(Integer id,ProductBody productBody);
    void deleteProductById(Integer id);
}
