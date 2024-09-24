package decimal.to.binary.calculator;
import java.util.Scanner;

public class DecimalToBinaryCalculator {
    public static void main(String[] args) {
        
        int n = 0;
        
        // Loop the whole code
        while (n < 1) {
            Scanner myObj = new Scanner(System.in);
            System.out.println("Enter a decimal number");
            int decimalNumber = myObj.nextInt();
            myObj.nextLine(); // Fill in the new line left by nextInt();

            int[] binaryNumber = {64, 32, 16, 8, 4, 2, 1}; // Store powers of two inside array

            for (int i = 0; i < 7; i++) { // Loop through each power of two (64, 32, 16, 8, 4, 2, 1)
                if (decimalNumber >= binaryNumber[i]) { // Check if decimal number is greater than or equal to the current power of two
                    decimalNumber = decimalNumber - binaryNumber[i]; // Subtract the power of two from the decimal number
                    System.out.print('1'); // Print '1' to indicate the current power of two is used
                } else {                   // If decimal number is less than current power of two
                    System.out.print('0'); // Print '0' to indicate the current power of two is not used
                }
            } System.out.println(""); // New line
            
            System.out.println("Would you like to continue?");
            String exitCode = myObj.nextLine();
            
            if (exitCode.equalsIgnoreCase("YES")) { // Type "YES" if user wants to continue
            } else if (exitCode.equalsIgnoreCase("NO")) { //Type "NO" if user wants to stop
                n++;                               // Add 1 to value of n so loop will stop
                System.out.println("Game Over!");
                myObj.close();                      // Close Scanner
            } else {
            System.out.println("Sorry, that is not a valid number");
            myObj.nextLine();
            }
        }
    }
}