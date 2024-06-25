package com.cassandra.service;

import com.cassandra.entity.Product;
import com.cassandra.repository.ProductRepository;
import com.fasterxml.uuid.Generators;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) {
        product.setId(Generators.timeBasedGenerator().generate());
        return productRepository.save(product);
    }
}
