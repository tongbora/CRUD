package org.istad.crud.dao.impl;

import lombok.RequiredArgsConstructor;
import org.istad.crud.dao.ProductDao;
import org.istad.crud.dto.ProductBody;
import org.istad.crud.dto.ProductDto;
import org.istad.crud.model.Product;
import org.istad.crud.repository.ProductRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProdcutDaoImpl implements ProductDao {

    private final ProductRepositories productRepositories;

    @Override
    public void addProduct(Product product) {
        List<Product> products = getAllProduct();
        for (Product p : products) {
            if(p == product) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Product already exists");
            }
            productRepositories.save(product);
        }
    }

    @Override
    public List<Product> getAllProduct() {
         return productRepositories.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
            return productRepositories.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "Product not found")
                    );
    }

    @Override
    public void updateProductById(Integer id, Product product) {
        if(productRepositories.existsById(id)) {
            productRepositories.save(product);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
    }

    @Override
    public void deleteProductById(Integer id) {
       if(productRepositories.existsById(id)) {
           productRepositories.deleteById(id);
       }else{
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
       }
    }
}
