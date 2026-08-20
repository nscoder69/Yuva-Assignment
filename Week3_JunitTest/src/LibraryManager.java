import java.util.*;
public class LibraryManager {
    private final List<Book> books=new ArrayList<>();
    public void addBook(Book b){
        if(b==null||b.getIsbn()==null||b.getIsbn().isBlank()) throw new IllegalArgumentException("Book and ISBN required");
        if(findByIsbn(b.getIsbn()).isPresent()) throw new IllegalArgumentException("Duplicate ISBN");
        books.add(b);
    }
    public List<Book> listBooks(){return Collections.unmodifiableList(books);}
    public Optional<Book> findByIsbn(String isbn){return books.stream().filter(b->b.getIsbn().equals(isbn)).findFirst();}
    public void updateBook(String isbn,String title,String author,int year){
        Book b=findByIsbn(isbn).orElseThrow(()->new NoSuchElementException("Book not found"));
        if(title==null||title.isBlank()||author==null||author.isBlank()||year<=0) throw new IllegalArgumentException("Invalid details");
        b.setTitle(title); b.setAuthor(author); b.setPublicationYear(year);
    }
    public void deleteBook(String isbn){
        Book b=findByIsbn(isbn).orElseThrow(()->new NoSuchElementException("Book not found"));
        books.remove(b);
    }
}