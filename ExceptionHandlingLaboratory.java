package banking.system;

import java.util.Scanner;

public class BankingSystem {

    String userName;
    int accountBalance;

    // Constructor
    public BankingSystem(String userName, int accountBalance) {
        this.userName = userName;
        this.accountBalance = accountBalance;
    }

    Scanner input = new Scanner(System.in);

    public class InsufficientFundsException extends Exception { // Custom exception for withdrawal

        private int amountWithdraw;

        public InsufficientFundsException(int amount) {
            super("Insufficient funds for withdrawal: " + amount); // Gets called when typed e.getMessage()
            this.amountWithdraw = amount;
        }

        public int getAmountWithdraw() {
            return amountWithdraw;
        }
    }

    // Code starts with saying hi
    public void sayHi() {
        System.out.println("Hi " + userName + ", what would you like to do?");
    }

    public void bankOptions() {
        System.out.println("\nDeposit \nWithdraw \nCheck Balance \nExit");
    }

    // Logic for deposit function
    public boolean depositAmount() {
        System.out.println("Enter the amount you would like to deposit.");
        while (true) {
            String bankOption = input.nextLine();
            if (bankOption.equalsIgnoreCase("Back")) {
                System.out.println("Returning to the Main Menu");
                return false;
            }
            try {
                int deposit = Integer.parseInt(bankOption);
                if (deposit < 0) { // If deposit amount is less than 0
                    System.out.println("Invalid amount. Please enter a valid amount!");
                } else {
                    accountBalance += deposit; // Add the deposit amount to the total of account balance
                    System.out.println("Your despoit has been successfully added to your balance \nYour new balance is: " + accountBalance);
                    return true; // Terminates the loop
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input Luhh kulit ka?");
            }
        }
    }

    // Logic function for withdraw function
    public boolean withdrawAmount() {
        System.out.println("How much would you like to withdraw?");
        while (true) {
            String bankOption = input.nextLine();
            if (bankOption.equalsIgnoreCase("Back")) {
                System.out.println("Returning to the Main Menu");
                return false;
            }
            try {
                int amountWithdraw = Integer.parseInt(bankOption);

                if (amountWithdraw > accountBalance) { // If the amount withdraw is greater than the value of account balance
                    throw new InsufficientFundsException(amountWithdraw);
                } else if (amountWithdraw <= 0) {                   // If the amount withdraw is less than or equal to 0
                    System.out.println("Invalid withdrawal amount! Please enter a positive amount.");
                } else {
                    accountBalance -= amountWithdraw; // Subtract amount withdrawn to the total of account balance
                    System.out.println("Your withdrawal has been processed! Remaining balance: " + accountBalance);
                    return true; // Terminates the loop
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid numeric amount!");
            } catch (InsufficientFundsException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    // Print balance

    public void checkBalance() {
        System.out.println("Your current balance is: " + accountBalance);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BankingSystem action = new BankingSystem("Steven Paulo Perando", 100000);

        action.sayHi();
        boolean loopChecker = false;
        
        while (!loopChecker) {
            action.bankOptions();
            String bankOption = input.nextLine();
            if (bankOption.equalsIgnoreCase("Withdraw")) {
                loopChecker = action.withdrawAmount(); // Update loopChecker based on success
            } else if (bankOption.equalsIgnoreCase("Deposit")) {
                loopChecker = action.depositAmount(); // Update loopChecker based on success
            } else if (bankOption.equalsIgnoreCase("Check Balance")) {
                action.checkBalance();
                loopChecker = true; // Ends the loop after checking balance
            } else if (bankOption.equalsIgnoreCase("Exit")) {
                System.out.println("Thank you for using our services! \nThe program will now be terminated.");
                loopChecker = true; // Ends the loop
            } else {
                System.out.println("Invalid Input, please try again");
            }
        }
    }
}
