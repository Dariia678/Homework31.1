import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class LibraryTest {
    // Тест для метода addBook
    @Test
    public void testAddBook() {
        Library library = new Library();
        Book book = new Book("Title1", "Author1");

        library.addBook(book);
        List<Book> books = library.getBooks();

        // Проверяем, что книга добавлена
        assertEquals(1, books.size());
        assertTrue(books.contains(book));
    }

    // Тест для метода removeBook
    @Test
    public void testRemoveBook() {
        Library library = new Library();
        Book book = new Book("Title1", "Author1");

        library.addBook(book);
        boolean result = library.removeBook(book);

        // Проверяем, что книга была успешно удалена
        assertTrue(result);
        assertEquals(0, library.getBookCount());
    }

    // Тест на удаление книги, которой нет в библиотеке
    @Test
    public void testRemoveNonExistentBook() {
        Library library = new Library();
        Book book = new Book("Title1", "Author1");

        // Пытаемся удалить книгу, которой нет в библиотеке
        boolean result = library.removeBook(book);

        // Проверяем, что удаление вернет false
        assertFalse(result);
    }

    // Тест для метода getBooks
    @Test
    public void testGetBooks() {
        Library library = new Library();
        Book book1 = new Book("Title1", "Author1");
        Book book2 = new Book("Title2", "Author2");

        library.addBook(book1);
        library.addBook(book2);

        List<Book> books = library.getBooks();

        // Проверяем, что список книг содержит добавленные книги
        assertEquals(2, books.size());
        assertTrue(books.contains(book1));
        assertTrue(books.contains(book2));
    }

    // Тест для метода addBook с некорректными данными
    @Test
    public void testAddInvalidBook() {
        Library library = new Library();

        // Проверяем, что при добавлении книги с null полями бросается исключение
        assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(new Book(null, "Author1"));
        });

        assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(null);
        });
    }

    // Тест для метода getBookCount
    @Test
    public void testGetBookCount() {
        Library library = new Library();
        Book book = new Book("Title1", "Author1");

        assertEquals(0, library.getBookCount());

        library.addBook(book);
        assertEquals(1, library.getBookCount());

        library.removeBook(book);
        assertEquals(0, library.getBookCount());
    }
}
