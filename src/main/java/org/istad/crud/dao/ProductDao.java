package org.istad.crud.dao;

import org.istad.crud.dto.ProductBody;
import org.istad.crud.model.Product;

import java.util.List;

public interface ProductDao {
    void addProduct(Product product);
    List<Product> getAllProduct();
    Product getProductById(Integer id);
    void updateProductById(Integer id,Product product);
    void deleteProductById(Integer id);
}
