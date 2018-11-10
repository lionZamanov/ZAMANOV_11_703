package ru.itis.repositories;

import lombok.SneakyThrows;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Product;
import ru.itis.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

/**
 * 22.10.2018
 * UsersRepositoryJdbcTemplateImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    private JdbcTemplate jdbcTemplate;
    private ProductRepository productRepository;

    private Connection connection;
    private Statement statement;
    private static final String URL = "jdbc:postgresql://localhost:5432/shop";
    private static final String USER = "postgres";
    private static final String PASSWORD = "adminroot";

    //language=SQL
    private static final String SQL_SELECT_USER_BY_ID =
            "select * from shop_user where id = ?";

    //language=SQL
    private static final String SQL_SELECT_ALL_USERS =
            "select * from shop_user";

    //language=SQL
    private static final String SQL_INSERT =
            "insert into shop_user(name, password_hash, age) values (?, ?, ?)";

    //language=SQL
    private static final String SQL_SELECT_BY_NAME =
            "select * from shop_user where name = ?";

   /* TODO: НА ВСЕ ТАКИЕ ЗАПРОСЫ ДЕЛАТЬ? КАК ДЕЛАТЬ JOIN'Ы?
    private static final String SQL_ADD_PRODUCT_TO_USER =
            "INSERT INTO user_products VALUES ('?')";*/

    private RowMapper<User> userRowMapper = (resultSet, i) -> User.builder()
            .id(resultSet.getLong("id"))
            .name(resultSet.getString("name"))
            .passwordHash(resultSet.getString("password_hash"))
            .build();

    @SneakyThrows
    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        statement = connection.createStatement();
        productRepository = new ProductRepositoryImpl(dataSource);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL_USERS, userRowMapper);
    }

    //TODO: на каком уровне с продуктами здесь работаю? REPOSITORY или SERVICE?
    @Override
    public User find(Long id) {
        User user = jdbcTemplate.queryForObject(SQL_SELECT_USER_BY_ID,
                userRowMapper, id);
        user.setBasket(productRepository.findUserBasket(user.getId()));
        return user;
    }

    @Override
    public void save(User model) {
        jdbcTemplate.update(SQL_INSERT, model.getName(), model.getPasswordHash(), model.getAge());
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(User model) {

    }

    @Override
    public User findByName(String name) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_BY_NAME, userRowMapper, name);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    @SneakyThrows
    public User finByCookie(String cookie) {
        //language=SQL
        ResultSet resultSet = statement.executeQuery("SELECT * FROM auth WHERE cookie_value = '" + cookie + "';");
        resultSet.next();
        Long id = resultSet.getLong("user_id");
        User user = jdbcTemplate.queryForObject(SQL_SELECT_USER_BY_ID,
                userRowMapper, id);
        productRepository.findUserBasket(user.getId());
        user.setBasket(productRepository.findUserBasket(user.getId()));
        return user;
    }

    @Override
    @SneakyThrows
    public boolean addProduct(User user, Product product) {
        return statement.execute("INSERT INTO user_products VALUES ('" + product.getId() + "','" + user.getId() + "')");
    }
}
