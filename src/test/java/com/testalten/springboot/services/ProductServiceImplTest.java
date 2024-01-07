package com.testalten.springboot.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceImplTest {

    // Déclaration du logueur
    private final static Logger log = LoggerFactory.getLogger(ProductServiceImplTest.class);

    @Autowired
    private ProductService service;

    @BeforeEach
    void setUp() {
        log.info("START TEST Product SetUp ...");
        assertNotNull(service, "ProductService is NULL !!!!");
    }

    @Test
    @DisplayName("Test_findAllProducts")
    void findAllProducts() {
        log.info("START Test_findAllProducts ...");
        var lst = service.getAll();
        lst.forEach(f -> log.info("product : {}", f));
        log.info("Number of products : {}", lst.size());
        log.info("END Test_findAllProducts ...");
        assertNotNull(lst);
    }

    @Test
    void findProductById() {
        log.info("START TEST findProductById ...");
        var f = service.getOne(1004L);
        log.info("product : {}", f);
        log.info("END TEST findProductById ...");
    }
}
