package library.management.system;
import java.util.Scanner;
import Classes.Library;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Add three books!\nWhat is the title of the first book?");
        String input = myObj.nextLine();

        System.out.println("Who is the author of the first book?");
        myObj.nextLine();

        System.out.println("What is the title of the second book?");
        myObj.nextLine();

        System.out.println("Who is the author of the second book?");
        myObj.nextLine();

        System.out.println("What is the title of the third book?");
        myObj.nextLine();

        System.out.println("Who is the author of the third book?");
        myObj.nextLine();

        Library bookList = new Library();
        bookList.addBook(input);
        bookList.addBook(input);
        bookList.addBook(input);
        System.out.println("You've successfully added three books!");
        System.out.println("What would you like to do?");
        System.out.println("A. Display all books \nB. Borrow a book \nC. Return a book \nD. Search for a book by title \nE. Exit");
        String input2 = myObj.nextLine();

        switch (input2) {
            case "A":
                bookList.displayAllBooks();
                break;
            case "B":
                bookList.borrowBook(input);
                break;
            case "C":
                bookList.returnBook(input);
                break;
            case "D":
                bookList.searchBookByTitle(input);
                break;
            case "E":
                System.out.println("The program has been terminated");
                break;
        }
    }
}
