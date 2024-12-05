package ClassAndObject;

public class Book {
    public String title;
    public String publishedAt;
    public int price;
    public String isbn;
    public Author author;
    public Publisher publisher;

    public Book(String title, String publishedAt, int price, String isbn) {
        this.title = title;
        this.publishedAt = publishedAt;
        this.price = price;
        this.isbn = isbn;
    }
}
