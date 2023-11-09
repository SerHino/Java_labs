
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Bookshelf bookshelf = Bookshelf.getInstance();
        BookGenerator bookGenerator = new BookGenerator();

        Book fantasyBook1 = bookGenerator.createBook("fantasy");
        Book comicsBook1 = bookGenerator.createBook("comics");

        bookshelf.addBook(fantasyBook1);
        bookshelf.addBook(comicsBook1);

        Book fantasyBook2 = bookGenerator.createBook("fantasy");
        bookshelf.addBook(fantasyBook2);

        System.out.println("Books on the bookshelf:");
        bookshelf.displayBooks();
        //bookshelf.removeBook(fantasyBook2);
        //bookshelf.displayBooks();
    }
}
