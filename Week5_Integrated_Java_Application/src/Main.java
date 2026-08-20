package inventory;

import java.util.*;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final LibraryManager LIBRARY = new LibraryManager();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            try {
                switch (SCANNER.nextLine().trim()) {
                    case "1" -> addBook();
                    case "2" -> listBooks();
                    case "3" -> updateBook();
                    case "4" -> deleteBook();
                    case "5" -> running = false;
                    default -> System.out.println("Invalid option.");
                }
            } catch (RuntimeException ex) {
                System.out.println("Operation failed: " + ex.getMessage());
            }
        }
        System.out.println("Application closed.");
    }

    private static void printMenu() {
        System.out.println("\n=== Library Inventory ===");
        System.out.println("1. Add book\n2. List books\n3. Update book\n4. Delete book\n5. Exit");
        System.out.print("Choose: ");
    }

    private static void addBook() {
        System.out.print("Title: "); String title=SCANNER.nextLine();
        System.out.print("Author: "); String author=SCANNER.nextLine();
        System.out.print("ISBN: "); String isbn=SCANNER.nextLine();
        System.out.print("Publication year: "); int year=Integer.parseInt(SCANNER.nextLine());
        LIBRARY.addBook(new Book(title,author,isbn,year));
        System.out.println("Book added.");
    }

    private static void listBooks() {
        if (LIBRARY.listBooks().isEmpty()) System.out.println("No books found.");
        else LIBRARY.listBooks().forEach(System.out::println);
    }

    private static void updateBook() {
        System.out.print("ISBN: "); String isbn=SCANNER.nextLine();
        System.out.print("New title: "); String title=SCANNER.nextLine();
        System.out.print("New author: "); String author=SCANNER.nextLine();
        System.out.print("New year: "); int year=Integer.parseInt(SCANNER.nextLine());
        LIBRARY.updateBook(isbn,title,author,year);
        System.out.println("Book updated.");
    }

    private static void deleteBook() {
        System.out.print("ISBN: "); String isbn=SCANNER.nextLine();
        LIBRARY.deleteBook(isbn);
        System.out.println("Book deleted.");
    }
}