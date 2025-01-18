package library.management.system;

import java.util.Scanner;
import Classes.Library;
import Classes.Book;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        Library library = new Library(); // Library instance

        System.out.println("Add three books!");
        System.out.println();

        // Loop questions to add three books
        for (int i = 1; i <= 3; i++) {
            System.out.println("What is the title of the book " + i + "?");
            String titleBook = myObj.nextLine();

            System.out.println("Who is the author of book " + i + "?");
            String authorBook = myObj.nextLine();
            
            library.addBook(new Book(titleBook, authorBook)); // Add books to Library
            System.out.println();
        }
        System.out.println("You've successfully added three books!");
        System.out.println();
        
        boolean loopBreaker = true; // Boolean to break loop
        
        // Loop for the menu.
        while (loopBreaker) {
            System.out.println("What would you like to do?");
            System.out.println("A. Display all books \nB. Borrow a book \nC. Return a book \nD. Search for a book by title \nE. Exit");
            String input = myObj.nextLine();

            switch (input) {
                case "A":
                    library.displayAllBooks(); // Display all books
                    break;
                case "B":
                    System.out.println("Which book would you like to borrow?");
                    String borrowBookTitle = myObj.nextLine();
                    Book bookToBorrow = library.getBookByTitle(borrowBookTitle); 
                    
                    // Perform search for book, if book was found, get the book.
                    if (bookToBorrow != null) {
                        bookToBorrow.borrowBook(borrowBookTitle); // Borrow book.
                    } else {
                        System.out.println("The book you are trying to borrow is not found");
                    }
                    break;
                case "C":
                    System.out.println("Which book would you like to return?");
                    String returnTitle = myObj.nextLine();
                    Book bookToReturn = library.getBookByTitle(returnTitle);
                    
                    // Perform search for book, if book was not found, return the book.
                    if(bookToReturn != null) {
                        bookToReturn.returnBook(returnTitle); // Return book.
                    } else {
                        System.out.println("The book you are trying to return is not found");
                    }
                    break;
                case "D":
                    System.out.println("What book would you like to search?");
                    String searchTitle = myObj.nextLine();
                    library.searchBookByTitle(searchTitle); // Search book.
                    break;
                case "E":
                    System.out.println("The program has been terminated");
                    loopBreaker = false; // Break loop
            }
        System.out.println();
        }
    }
}
