package joon.java_practice;

import ClassAndObject.Author;
import ClassAndObject.Book;
import ClassAndObject.Publisher;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MyClassTest {
    @Test
    void book() throws Exception {
        Author bernard_Werber = new Author("베르나르 베르베르","1961년 9월 18일");

        System.out.println(bernard_Werber);

        Book gami = new Book("개미","1991",14220,"9788932923581");
        Book thanatonautes = new Book("타나토노트","1994",14220,"9788932903200");

        List<Book> bernardBooks = new ArrayList<>(List.of(gami,thanatonautes));

        bernard_Werber.books = bernardBooks;
        System.out.println(bernard_Werber.books.get(0).title);
    }
}
