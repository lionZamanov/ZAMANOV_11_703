package ru.itis.services;

import ru.itis.models.Product;
import ru.itis.repositories.ProductRepository;

import java.util.List;

public class ProductsServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductsServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //TODO: Зачем я это делаю?
    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
    @Override
    public Product getProductById(Long id) {
        return productRepository.findProductById(id);
    }
}
