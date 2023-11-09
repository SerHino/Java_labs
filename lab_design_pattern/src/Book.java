public abstract class Book implements Cloneable {
    private String ISBN;
    private int pageCount;
    private String genre;

    public Book clone() throws CloneNotSupportedException {
        return (Book) super.clone();
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
