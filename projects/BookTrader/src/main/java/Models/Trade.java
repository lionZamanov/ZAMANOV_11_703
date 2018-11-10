package Models;

import lombok.*;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Trade {
    private User firstUser;
    private User secondUser;
    private List<Book> firstUserOffer;
    private List<Book> secondUserOffer;
    private boolean wasCompleted;
}
