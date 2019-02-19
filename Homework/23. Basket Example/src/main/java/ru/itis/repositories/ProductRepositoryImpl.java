package ru.itis.repositories;

import lombok.SneakyThrows;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.itis.models.Basket;
import ru.itis.models.Product;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    private JdbcTemplate jdbcTemplate;

    public ProductRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //language=SQL
    private static final String SQL_SELECT_GET_ALL_PRODUCTS =
            "select * from product;";
    //language=SQL
    private static final String SQL_SELECT_GET_PRODUCT_BY_ID =
            "select * from product WHERE product_id = ?;";
    //language=SQL
    private static final String SQL_SELECT_GET_USER_BASKET_BY_ID =
            "select * from (SELECT * FROM user_products WHERE user_id = ?) AS saf JOIN product ON saf.product_id = product.product_id;";

    private RowMapper<Product> productRowMapper = (resultSet, i) -> Product.builder()
            .id(resultSet.getLong("product_id"))
            .title(resultSet.getString("product_name"))
            .cost(resultSet.getInt("cost"))
            .build();

    @Override
    @SneakyThrows
    public List<Product> findAll() {
        return jdbcTemplate.query(SQL_SELECT_GET_ALL_PRODUCTS, productRowMapper);
    }

    @Override
    public List<Product> findUserProducts(Long id) {
        List<Product> pr =  jdbcTemplate.query(SQL_SELECT_GET_USER_BASKET_BY_ID, productRowMapper, id);
        return pr;
    }

    @Override
    public Product find(Long id) {
        return jdbcTemplate.query(SQL_SELECT_GET_PRODUCT_BY_ID, productRowMapper, id).get(0);

    }

    @Override
    public void save(Product model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Product model) {

    }
}
