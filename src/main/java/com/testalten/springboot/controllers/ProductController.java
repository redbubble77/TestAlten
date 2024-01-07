package com.testalten.springboot.controllers;

import com.testalten.springboot.entities.Product;
import com.testalten.springboot.services.ProductService;

import org.springframework.http.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final static Logger log = LoggerFactory.getLogger(ProductController.class);

    private ProductService service;

    public ProductController(ProductService service) {
        log.trace("Product controller instanced");
        this.service = service;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addProduct(@RequestBody Product product) {
        service.save(product);
        log.info("Product : " + product.getId() + " added");
    }

    @GetMapping({ "", "/all" })
    public List<Product> getAllProducts() {
        return service.getAll();
    }

    @GetMapping({ "/{id}" })
    public Product getProductById(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Product product, @PathVariable Long id) {

        Product productToAdd = service.getOne(id);
        productToAdd.setCode(product.getCode());
        productToAdd.setCategory(product.getCategory());
        productToAdd.setDescription(product.getDescription());
        productToAdd.setImage(product.getImage());
        productToAdd.setName(product.getName());
        productToAdd.setPrice(product.getPrice());
        productToAdd.setQuantity(product.getQuantity());
        productToAdd.setRating(product.getRating());
        productToAdd.setStatus(product.getStatus());
        service.save(productToAdd);
        log.info("Product : " + id + " updated");
    }

    @PatchMapping("/{id}")
    public void patch(@RequestBody Product product, @PathVariable Long id) {

        Product productToAdd = service.getOne(id);
        if (productToAdd != null) {
            productToAdd.setCode(product.getCode());
            productToAdd.setCategory(product.getCategory());
            productToAdd.setDescription(product.getDescription());
            productToAdd.setImage(product.getImage());
            productToAdd.setName(product.getName());
            productToAdd.setPrice(product.getPrice());
            productToAdd.setQuantity(product.getQuantity());
            productToAdd.setRating(product.getRating());
            productToAdd.setStatus(product.getStatus());
            service.save(productToAdd);
            log.info("Product : " + id + " patched");
        } else
            log.info("Patch Error : Product : " + id + " doesn't exist");

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
        log.info("Product : " + id + " deleted");
    }
}
