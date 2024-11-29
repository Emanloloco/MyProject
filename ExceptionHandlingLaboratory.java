package exception.handling.laboratory;

import java.util.Scanner;

public class ExceptionHandlingLaboratory {

    String userName;
    int accountBalance;

    // Constructor
    public ExceptionHandlingLaboratory(String userName, int accountBalance) {
        this.userName = "Steven Paulo Perando";
        this.accountBalance = 100000;
    }

    Scanner input = new Scanner(System.in);

    public void sayHi() {
        System.out.println("Hi " + userName + ", what would you like to do? \nDeposit \nWithdraw \nCheck Balance");
    }

    public void depositAmount() {
        System.out.println("Enter the amount you would like to deposit.");
        try {
            int deposit = input.nextInt();
            if (deposit < 0) {
                System.out.println("Invalid amount. Please enter a valid amount!");
            }
            else {
                accountBalance += deposit;
                System.out.println("Your despoit has been successfully added to your balance \nYour new balance is: " + accountBalance);
            }
        }
        catch (Exception e) {
            
        }
    }

    public void withdrawAmount() {
        boolean validInput = true;
        while (validInput) {
            try {
                System.out.println("How much would you like to withdraw?");
                int amountWithdraw = input.nextInt();
                
                if (amountWithdraw > accountBalance) {
                    System.out.println("Insufficient balance!");
                } else if (amountWithdraw <= 0) {
                    System.out.println("Invalid withdrawal amount!");
                } else {
                    accountBalance -= amountWithdraw;
                    System.out.println("Your withdrawal has been processed! Remaining balance: " + accountBalance);
                    validInput = false;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid amount!");
                input.next(); // Clear the invalid input
            }
        }
    }

    public void checkBalance() {
        System.out.println("Your current balance is: " + accountBalance);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ExceptionHandlingLaboratory action = new ExceptionHandlingLaboratory("Steven Paulo Perando", 100000);

        action.sayHi();
        String bankOption = input.nextLine();
        if (bankOption.equalsIgnoreCase("Withdraw")) {
            action.withdrawAmount();
        } else if (bankOption.equalsIgnoreCase("Deposit")) {
            action.depositAmount();
        } else if (bankOption.equalsIgnoreCase("Check Balance")) {
            action.checkBalance();
        } else {
            System.out.println("Invalid Input, please try again");
        }
    }
}
