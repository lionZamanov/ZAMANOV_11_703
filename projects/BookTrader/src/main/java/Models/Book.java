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
public class Book {
    private String name;
    private String author;
    //private List<Category> Categories;
    private double cost;
}
