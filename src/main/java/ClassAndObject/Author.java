package ClassAndObject;

import java.util.ArrayList;
import java.util.List;

public class Author {
    String name;
    String dateOfBirth;
    List<Book> books = new ArrayList<>();

    public Author(String name, String dateOfBirth, List<Book> books) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.books = books;
    }
}
