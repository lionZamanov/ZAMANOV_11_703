package Service;

import Models.Book;
import Repository.BooksRepository;

public class BooksServiceImpl implements BooksService {

    private BooksRepository booksRepository;

    public BooksServiceImpl(BooksRepository booksRepository){
       this.booksRepository = booksRepository;
    }

    @Override
    public void addNewBook(Book book) {
        if(!isExist(book)){
            booksRepository.save(book);
        }else{
            System.out.println("Книга уже существует");
        }
    }

    public boolean isExist(Book book){
        if(booksRepository.findByName(book.getName()) == null){
            return false;
        }else if(booksRepository.findByName(book.getName()).equals(book)){
            return true;
        }
        return false;
    }
}
