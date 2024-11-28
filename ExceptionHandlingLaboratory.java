package exceptionhandlinglaboratory;

import java.util.Scanner;

public class ExceptionHandlingLaboratory {

    String userName;
    int accountBalance;

    // Constructor
    public ExceptionHandlingLaboratory(String userName, int accountBalance) {
        this.userName = 
    }

    Scanner input = new Scanner(System.in);
    
    public void sayHi() {
        System.out.print("Hi " + userName + ", what would you like to do?");
    }

    public void depositAmount() {

    }

    public void withdrawAmount(Scanner input, int accountBalance) {
        input.nextInt();
        int amountWithdraw = input.nextInt();
        while (amountWithdraw < accountBalance) {
            try {
                if (amountWithdraw < accountBalance) {
                    System.out.println("Insufficient Balance");
                }
                else {
                    accountBalance = accountBalance - amountWithdraw;
                    System.out.println("Your withdrawal has been processed!");
                }
            } catch (Exception e) {
                System.out.print("Insufficient Balance!");
            }
        }
    }
    
    public void printCurrentBalance(int accountBalance) {
        System.out.println("Your current balance is: " + accountBalance);
    }

    public static void main(String[] args) {

        ExceptionHandlingLaboratory action = new ExceptionHandlingLaboratory("Steven Paulo Perando", 100000);
        
        action.sayHi();
        action.withdrawAmount();
    }
}
