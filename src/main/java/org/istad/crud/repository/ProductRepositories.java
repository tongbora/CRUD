package org.istad.crud.repository;

import org.istad.crud.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositories extends JpaRepository<Product, Integer> {
    boolean existsProductById(Integer id);
}
