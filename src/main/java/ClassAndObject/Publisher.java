package ClassAndObject;

import java.util.ArrayList;
import java.util.List;

public class Publisher {
    String name;
    List<Book> books = new ArrayList<>();

    public Publisher(String name) {
        this.name = name;
    }
}