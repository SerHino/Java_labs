import java.util.ArrayList;
import java.util.List;

public class Bookshelf {
    private static Bookshelf instance = new Bookshelf();

    private List<Book> books;

    private Bookshelf() {
        books = new ArrayList<>();
    }

    public static Bookshelf getInstance() {
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }
}
