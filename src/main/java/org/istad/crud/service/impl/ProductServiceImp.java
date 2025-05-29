package org.istad.crud.service.impl;

import lombok.RequiredArgsConstructor;
import org.istad.crud.dao.ProductDao;
import org.istad.crud.dto.ProductBody;
import org.istad.crud.dto.ProductDto;
import org.istad.crud.model.Product;
import org.istad.crud.service.ProductService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {
    private final ProductDao productDao;


    @Override
    public void addProduct(ProductBody productBody) {
        Product product = new Product();
        product.setUuid(UUID.randomUUID().toString());
        product.setName(productBody.name());
        product.setUuid(UUID.randomUUID().toString());
        product.setBrand(productBody.brand());
        product.setCategory(productBody.category());
        product.setPrice(productBody.price());
        product.setDescription(productBody.description());
        product.setCreatedAt(LocalDateTime.now());
        product.setImageFileName(productBody.imageFileName());
        productDao.addProduct(product);
    }

    @Override
    public List<ProductDto> getAllProduct() {
        List<Product> products = productDao.getAllProduct();
        return products.stream()
                .map(product -> new ProductDto(
                        product.getId(),
                        product.getName(),
                        product.getBrand(),
                        product.getCategory(),
                        product.getPrice(),
                        product.getDescription(),
                        product.getImageFileName()
                        ))
                .toList();
    }

    @Override
    public ProductDto getProductById(Integer id) {
        Product product = productDao.getProductById(id);
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getBrand(),
                product.getCategory(),
                product.getPrice(),
                product.getDescription(),
                product.getImageFileName()
        );
    }

    @Override
    public void updateProductById(Integer id, ProductBody productBody) {
        Product product = productDao.getProductById(id);
        product.setName(productBody.name());
        product.setBrand(productBody.brand());
        product.setCategory(productBody.category());
        product.setPrice(productBody.price());
        product.setDescription(productBody.description());
        product.setImageFileName(productBody.imageFileName());
        productDao.updateProductById(id, product);
    }

    @Override
    public void deleteProductById(Integer id) {
        productDao.deleteProductById(id);
    }
}
