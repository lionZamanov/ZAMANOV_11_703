package ru.itis.repositories;

import lombok.SneakyThrows;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
    private BasketRepository basketRepository;

    private Connection connection;
    private Statement statement;

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
            .basket(basketRepository.findUserBasket(resultSet.getLong("id")))
            .name(resultSet.getString("name"))
            .passwordHash(resultSet.getString("password_hash"))
            .build();

    @SneakyThrows
    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        connection = dataSource.getConnection();
        statement = connection.createStatement();
        basketRepository = new BasketRepository(dataSource);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL_USERS, userRowMapper);
    }

    //TODO: на каком уровне с продуктами здесь работаю? REPOSITORY или SERVICE?
    @Override
    public User find(Long id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_USER_BY_ID, userRowMapper, id);
    }

    @Override
    public void save(User model) {
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, model.getName());
            ps.setString(2, model.getPasswordHash());
            ps.setInt(3, model.getAge());
            return ps;
        }, holder);
        Long newUserId = Long.valueOf(holder.getKeys().get("id").toString());
        basketRepository.newBasket(newUserId);
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
            User user = jdbcTemplate.queryForObject(SQL_SELECT_BY_NAME, userRowMapper, name);
            return user;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    @SneakyThrows
    public User findByCookie(String cookie) {
        //language=SQL
        ResultSet resultSet = statement.executeQuery("SELECT * FROM auth WHERE cookie_value = '" + cookie + "';");
        resultSet.next();
        Long id = resultSet.getLong("user_id");
        return jdbcTemplate.queryForObject(SQL_SELECT_USER_BY_ID, userRowMapper, id);
    }

    @Override
    @SneakyThrows
    public boolean addProduct(User user, Product product) {
        ResultSet result = statement.executeQuery("SELECT * FROM user_products WHERE product_id = " + product.getId() + " AND user_id = " + user.getId() + ";");
        if (result.next()) {
            int count = result.getInt("count") + 1;
            return statement.execute("UPDATE user_products SET count = '" + count + "' WHERE product_id = " + product.getId() + " AND user_id = " + user.getId() + ";");
        }
        String sql = "INSERT INTO user_products VALUES (" + product.getId() + "," + user.getId() + ", 1 );";
        return statement.execute(sql);
    }


}
