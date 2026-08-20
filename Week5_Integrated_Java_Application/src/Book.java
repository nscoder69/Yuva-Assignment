package inventory;

public class Book {
    private final String isbn;
    private String title;
    private String author;
    private int publicationYear;

    public Book(String title, String author, String isbn, int publicationYear) {
        if (isbn == null || isbn.isBlank()) throw new IllegalArgumentException("ISBN is required");
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
    }
    public String getTitle(){ return title; }
    public String getAuthor(){ return author; }
    public String getIsbn(){ return isbn; }
    public int getPublicationYear(){ return publicationYear; }
    public void setTitle(String title){ this.title=title; }
    public void setAuthor(String author){ this.author=author; }
    public void setPublicationYear(int year){ this.publicationYear=year; }
    @Override public String toString(){
        return title+" | "+author+" | ISBN: "+isbn+" | Year: "+publicationYear;
    }
}