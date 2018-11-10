package Repository;

import Models.Book;
import Models.Category;
import Models.Trade;
import Models.User;

import java.util.List;

public interface BooksRepository extends CrudRepository<Book> {
    Book findByName(String name);
    Book findByAuthor(String author);
    //Book findByCategory(Category category);
}
