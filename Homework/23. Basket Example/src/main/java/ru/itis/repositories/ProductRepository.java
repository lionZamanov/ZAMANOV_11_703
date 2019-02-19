package ru.itis.repositories;

import ru.itis.models.Basket;
import ru.itis.models.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product> {
    List<Product> findAll();
    List<Product> findUserProducts(Long id);
}
