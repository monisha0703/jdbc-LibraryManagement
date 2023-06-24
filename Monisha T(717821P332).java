package Module;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        
        return title;
        
    }

    public String getAuthor() {
        
        return author;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        
        books.add(book);
    }

    public void removeBook(Book book) {
        
        books.remove(book);
    }

    public List<Book> searchBooks(String keyword) {
        List<Book> searchResults = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().contains(keyword) || book.getAuthor().contains(keyword)) {
                searchResults.add(book);
            }
        }
        return searchResults;
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Library library = new Library();

        
        library.addBook(new Book("Java: A Beginner's Guide", "Herbert Schildt"));
        library.addBook(new Book("Clean Code: A Handbook of Agile Software Craftsmanship", "Robert C. Martin"));
        library.addBook(new Book("Design Patterns: Elements of Reusable Object-Oriented Software", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    System.out.print("Enter book title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    author = scanner.nextLine();
                    Book bookToRemove = new Book(title, author);
                    library.removeBook(bookToRemove);
                    System.out.println("Book removed successfully.");
                    break;
                case 3:
                    System.out.print("Enter search keyword: ");
                    String keyword = scanner.nextLine();
                    List<Book> searchResults = library.searchBooks(keyword);
                    if (searchResults.isEmpty()) {
                        System.out.println("No books found matching the search criteria.");
                    } else {
                        System.out.println("Search Results:");
                        for (Book book : searchResults) {
                            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor());
                        }
                    }
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}

