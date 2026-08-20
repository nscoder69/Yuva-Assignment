public class Book {
    private String title, author, isbn;
    private int publicationYear;
    public Book(String title,String author,String isbn,int publicationYear){
        this.title=title; this.author=author; this.isbn=isbn; this.publicationYear=publicationYear;
    }
    public String getTitle(){return title;} public String getAuthor(){return author;}
    public String getIsbn(){return isbn;} public int getPublicationYear(){return publicationYear;}
    public void setTitle(String v){title=v;} public void setAuthor(String v){author=v;}
    public void setPublicationYear(int v){publicationYear=v;}
}