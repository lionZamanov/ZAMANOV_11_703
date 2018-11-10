package ru.itis.services;

import ru.itis.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product getProductById(Long id);
}
