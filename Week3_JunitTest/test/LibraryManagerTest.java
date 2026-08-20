import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.NoSuchElementException;
class LibraryManagerTest {
    LibraryManager library;
    @BeforeEach void setUp(){library=new LibraryManager();}
    @Test void addBook(){library.addBook(new Book("A","B","111",2020));assertEquals(1,library.listBooks().size());}
    @Test void duplicateIsbnRejected(){library.addBook(new Book("A","B","111",2020));assertThrows(IllegalArgumentException.class,()->library.addBook(new Book("C","D","111",2021)));}
    @Test void nullBookRejected(){assertThrows(IllegalArgumentException.class,()->library.addBook(null));}
    @Test void updateBook(){library.addBook(new Book("A","B","111",2020));library.updateBook("111","C","D",2025);assertEquals("C",library.findByIsbn("111").get().getTitle());}
    @Test void updateMissingFails(){assertThrows(NoSuchElementException.class,()->library.updateBook("999","C","D",2025));}
    @Test void deleteBook(){library.addBook(new Book("A","B","111",2020));library.deleteBook("111");assertTrue(library.listBooks().isEmpty());}
    @Test void deleteMissingFails(){assertThrows(NoSuchElementException.class,()->library.deleteBook("999"));}
    @Test void invalidUpdateFails(){library.addBook(new Book("A","B","111",2020));assertThrows(IllegalArgumentException.class,()->library.updateBook("111","","D",2025));}
    @Test void returnedListIsProtected(){library.addBook(new Book("A","B","111",2020));assertThrows(UnsupportedOperationException.class,()->library.listBooks().clear());}
}