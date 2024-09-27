import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        if (book == null || book.getTitle() == null || book.getAuthor() == null) {
            throw new IllegalArgumentException("Invalid book information");
        }
        books.add(book);
    }

    public boolean removeBook(Book book) {
        if (book == null || !books.contains(book)) {
            return false;
        }
        return books.remove(book);
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books); // return copy to avoid external modification
    }

    public int getBookCount() {
        return books.size();
    }
}
