package Classes;
import java.util.Scanner;

public class Book {
    String title;
    String author;
    boolean isAvailable = true;
    
    // Constructor to initialize a book with title and author.
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true; // Default availability set to true.
    }

    // Get the book title.
    public String getTitle() {
        return title;
    }

    // Get the book author.
    public String getAuthor() {
        return author;
    }
    
    // Display book details.
    public void displayBookDetails() {
        String availability;
        if(isAvailable) {
        availability = "YES";    
        } else {
            availability = "NO";
        }
        System.out.println("Title: " + title + "\nAuthor: " + author + "\nAvailability: " + availability);
    }

    // Borrow book marker
    public void borrowBook(String title) {
        System.out.println("Which book would you like to borrow?");
        if (isAvailable) {
            System.out.println("You have borrowed " + title);
            isAvailable = false;
        } else {
            System.out.println("The " + title + " book has not been returned yet. Please try borrowing another book");
        }
    }

    // Returned book marker
    public void returnBook(String title) {
        System.out.println("Which book are you returning?");
        if (!isAvailable) {
            System.out.println("You have returned " + title);
            isAvailable = true;
        } else {
            System.out.println("The " + title + " has not been borrowed yet!");
        }
    }
}
