package com.testalten.springboot.services;

import com.testalten.springboot.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Product getOne(Long id);

    Product save(Product product);

    void delete(Long id);
}
