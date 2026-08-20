import java.util.*;

public class LibraryManager {
    // ISBN is unique, so HashMap gives O(1) average lookup/update/delete.
    private final Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        validateBook(book);
        if (books.containsKey(book.getIsbn()))
            throw new IllegalArgumentException("ISBN already exists.");
        books.put(book.getIsbn(), book);
    }

    public Optional<Book> findByIsbn(String isbn) {
        return Optional.ofNullable(books.get(isbn));
    }

    public Collection<Book> getAllBooks() {
        return Collections.unmodifiableCollection(books.values());
    }

    public void updateBook(String isbn, String title, String author, int year) {
        Book book = books.get(isbn);
        if (book == null) throw new NoSuchElementException("Book not found.");
        if (title == null || title.isBlank() || author == null || author.isBlank() || year <= 0)
            throw new IllegalArgumentException("Invalid book details.");
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublicationYear(year);
    }

    public void deleteBook(String isbn) {
        if (books.remove(isbn) == null)
            throw new NoSuchElementException("Book not found.");
    }

    private void validateBook(Book book) {
        if (book == null) throw new IllegalArgumentException("Book cannot be null.");
        if (book.getIsbn() == null || book.getIsbn().isBlank())
            throw new IllegalArgumentException("ISBN is required.");
    }
}