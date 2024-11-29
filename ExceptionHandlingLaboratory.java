package exception.handling.laboratory;
import java.util.Scanner;

public class ExceptionHandlingLaboratory {
    String userName;
    int accountBalance;

    // Constructor
    public ExceptionHandlingLaboratory(String userName, int accountBalance) {
        this.userName = userName; // Fixed to use the provided userName
        this.accountBalance = accountBalance;
    }

    Scanner input = new Scanner(System.in);

    public void sayHi() {
        System.out.println("Hi " + userName + ", what would you like to do?");
    }

    public void depositAmount() {
        System.out.print("Enter amount to deposit: ");
        try {
            int amount = input.nextInt();
            if (amount <= 0) {
                System.out.println("Invalid deposit amount!");
            } else {
                accountBalance += amount;
                System.out.println("Deposit successful! Your new balance is: " + accountBalance);
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
            input.next(); // Clear the invalid input
        }
    }

    public void withdrawAmount() {
        System.out.print("Enter amount to withdraw: ");
        try {
            int amountWithdraw = input.nextInt();
            if (amountWithdraw > accountBalance) {
                System.out.println("Insufficient balance!");
            } else if (amountWithdraw <= 0) {
                System.out.println("Invalid withdrawal amount!");
            } else {
                accountBalance -= amountWithdraw;
                System.out.println("Your withdrawal has been processed! Remaining balance: " + accountBalance);
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
            input.next(); // Clear the invalid input
        }
    }

    public void printCurrentBalance() {
        System.out.println("Your current balance is: " + accountBalance);
    }

    public static void main(String[] args) {
        ExceptionHandlingLaboratory action = new ExceptionHandlingLaboratory("Steven Paulo Perando", 100000);

        action.sayHi();
        action.depositAmount();
        action.withdrawAmount();
        action.printCurrentBalance();
    }
}
