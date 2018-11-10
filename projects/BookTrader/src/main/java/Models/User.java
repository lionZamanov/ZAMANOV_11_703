package Models;

import Repository.UsersRepository;
import Repository.UsersRepositoryImpl;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String Registered;
    private String email;
    private String hashPassword;
    private String rawPassword;
    private String firstName;
    private String lastName;
    private String address;
    private List<Book> myBooks;
    private List<Book> myTrades;

    public List<Book> getMyBooks(){
        ResultSet bookResult = null;
        ArrayList<Book> arrayList = new ArrayList<>();
        try {
            statement = connection.createStatement();
            bookResult = statement.executeQuery("SELECT * FROM book_owner WHERE user = " + user.getId());
            bookResult.next();
            while (bookResult.next())
                arrayList.add(Book.builder()
                        .Author(bookResult.getString("author"))
                        .Name(bookResult.getString("Name"))
                        .Cost(bookResult.getDouble("cost")).build());
            return arrayList;
        } catch (SQLException e) {
            return null;
        }
        //
    }
    public List<Trade> getMyTrades(){
        ArrayList<Trade> arrayList = new ArrayList<>();
        UsersRepository usersRepository = new UsersRepositoryImpl(connection);
        ResultSet tradeResult = statement.executeQuery("SELECT * FROM trade WHERE  id_first_user = " + user.getId() + " OR id_second_user = " + user.getId());
        ArrayList<Book> firstOffer = new ArrayList<>();
        ResultSet firstOfferQuery = statement.executeQuery("SELECT * FROM book_offer WHERE  );
        while(firstOfferQuery.next()){
            firstOffer.add(Book.builder()
                    .name(firstOfferQuery.getString)
            )
        }
        tradeResult.next();
        while (tradeResult.next())
            arrayList.add(Trade.builder()
                    .firstUser((usersRepository).find(tradeResult.getInt("id_first_user")))
                    .secondUser((usersRepository).find(tradeResult.getInt("id_second_user")))
                    .firstUserOffer()
                    .secondUserOffer()
        return arrayList;
    }
    public List<Trade> getSuccessfulTrades(){
        return null;
    }

}
