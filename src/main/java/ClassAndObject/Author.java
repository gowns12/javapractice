package ClassAndObject;

import java.util.ArrayList;
import java.util.List;

public class Author {
    public String name;
    public String dateOfBirth;
    public List<Book> books = new ArrayList<>();

    public Author(String name, String dateOfBirth) throws Exception {
        if (name.length() > 10) {
            throw new Exception();
        }
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public Author(String name, String dateOfBirth, List<Book> books) throws Exception {
        if (name.length() > 10) {
            throw new Exception();
        }
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.books = books;
    }

    void changeName(String newName) throws Exception {
        if (name.length() > 10) {
            throw new Exception();
        }
        name = newName;
    }
}
