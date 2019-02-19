package ru.itis.services;

import ru.itis.repositories.ProductRepository;

public class ProductsServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductsServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

}
