package Repository;

import Models.Book;
import Models.Category;
import Models.Trade;
import Models.User;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BooksRepositoryImpl implements BooksRepository {
    private Connection connection;
    private Statement statement;

    @SneakyThrows
    public BooksRepositoryImpl(Connection connection) {
        this.connection = connection;
        statement = connection.createStatement();
    }

    @Override
    public Book findByName(String name) {
        //ArrayList<Category> categoryResult= statement.executeQuery("")
        return finder("name", name);
    }

    @Override
    public Book findByAuthor(String author) {
        return finder("author", author);
    }

    /*@Override
    public Book findByCategory(Category category) {
        return null;
    }*/

    private Book finder(String request, String value) {
        Statement statement = null;
        ResultSet bookResult = null;
        try {
            statement = connection.createStatement();
            bookResult = statement.executeQuery("SELECT * FROM book WHERE " + request + " = " + value);
            bookResult.next();
            return Book.builder()
                    .author(bookResult.getString("author"))
                    .name(bookResult.getString("Name"))
                    .cost(bookResult.getDouble("cost")).build();
        } catch (SQLException e) {
            return null;
        }
        //ArrayList<Category> categoryResult= statement.executeQuery("")
    }

    @Override
    @SneakyThrows
    public void save(Book model) {
        Statement statement = connection.createStatement();
        String query = "INSERT INTO book(name, author, cost) VALUES ('" + model.getName() + "','" + model.getAuthor() + "'," + model.getCost() + ")";
        int s = 1;
        statement.execute(query);

    }

    @Override
    public Book find(int id) {
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
