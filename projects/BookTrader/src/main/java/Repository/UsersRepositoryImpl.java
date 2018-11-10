package Repository;

import Models.User;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UsersRepositoryImpl implements UsersRepository {
    Connection connection;


    public UsersRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User findOneByEmail(String email) {
        return finder("email", email);
    }

    @SneakyThrows
    private User finder(String request, String value) {
        Statement statement = connection.createStatement();
        ResultSet bookResult = statement.executeQuery("SELECT * FROM book WHERE " + request + " = " + value);
        bookResult.next();
        return User.builder()
                .id(bookResult.getInt("id"))
                .hashPassword(bookResult.getString("hash_password"))
                .address(bookResult.getString("address"))
                .email(bookResult.getString("email"))
                .firstName(bookResult.getString("first_name"))
                .lastName(bookResult.getString("last_name"))
                .build();
    }

    @Override
    @SneakyThrows
    public void save(User model) {
        Statement statement = connection.createStatement();
        statement.execute("INSERT INTO trade_user(registered,email,hashpassword,firstname,lastname,address) VALUES ('" + model.getRegistered() + "','" + model.getEmail() + "','" + model.getHashPassword() + "','" + model.getFirstName() + "','" + model.getLastName() + "','" + model.getAddress() + "')");
    }

    @Override
    public User find(int id) {
        return finder("id", String.valueOf(id));
    }

    @Override
    public boolean update(int id) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }
}
