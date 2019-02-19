package ru.itis.repositories;

import lombok.*;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Basket;
import ru.itis.models.Product;
import ru.itis.models.ProductOrder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;


public class ProductOrderRepository {
    private JdbcTemplate jdbcTemplate;
    private ProductRepository productRepository;

    //language=SQL
    private static final String SQL_SELECT_USER_PRODUCTS_BY_ID =
            "select * from user_products where user_id = ? ORDER BY count";

    private RowMapper<ProductOrder> productOrderRowMapper = (resultSet, i) -> ProductOrder.builder()
            .product(productRepository.find(resultSet.getLong("product_id")))
            .count(resultSet.getInt("count"))
            .build();

    @SneakyThrows
    public ProductOrderRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        productRepository = new ProductRepositoryImpl(dataSource);
    }

    public List<ProductOrder> findUserProducts(Long id) {
        try {
            return jdbcTemplate.query(SQL_SELECT_USER_PRODUCTS_BY_ID, productOrderRowMapper, id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
