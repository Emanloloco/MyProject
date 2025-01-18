package Classes;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books; // List to store books in the library

    // Constructor to initialize the library
    public Library() {
        books = new ArrayList<>();
    }

    // Add a book to the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("You've added " + book.getTitle() + " to the library!");
    }

    // Display all books information
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library");
        } else {
            for (int i = 0; i < books.size(); i++) {
                Book book = books.get(i);
                book.displayBookDetails();
            }
        }
    }

    // Book information searcher.
    public void searchBookByTitle(String title) {
        for (int j = 0; j < books.size(); j++) { // Search for book by title.
            Book book = books.get(j);
            if (book.getTitle().equalsIgnoreCase(title)) { // If book was found, return info to the requestor.
                book.displayBookDetails();
                return;
            }
        }
        System.out.println("The book you are looking for is not found!");
    }

    // Book getter.
    public Book getBookByTitle(String title) {
        for (int k = 0; k < books.size(); k++) { // Search for book by title.
            Book book = books.get(k);
            if (book.getTitle().equals(title)) { // If book was found, return value to requestor.
                return book;
            }
        }
        return null;
    }
}
