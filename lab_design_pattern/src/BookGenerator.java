import java.util.HashMap;
import java.util.Map;

public class BookGenerator {
    private Map<String, Book> bookCache;

    public BookGenerator() {
        bookCache = new HashMap<>();
        bookCache.put("fantasy", new FantasyBook());
        bookCache.put("comics", new ComicsBook());
    }

    public Book createBook(String genre) throws CloneNotSupportedException {
        return bookCache.get(genre).clone();
    }
}
