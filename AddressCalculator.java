package address.calculator;

import java.util.Scanner;

public class AddressCalculator {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        
        System.out.print("Enter number of dimensions: ");
        int dimensions = myObj.nextInt();
        
        System.out.print("Enter base address: ");
        int baseAddress = myObj.nextInt();
        
        System.out.print("Enter element size: ");
        int elementSize = myObj.nextInt();
        
        int[] upperBounds = new int[dimensions];
        int[] targetElement = new int[dimensions];
        
        for (int i = 0; i < dimensions; i++) {
            System.out.print("Enter upper bound " + (i + 1) + ": ");
            upperBounds[i] = myObj.nextInt();
        }
        
        for (int i = 0; i < dimensions; i++) {
            System.out.print("Enter target element index " + (i + 1) + ": ");
            targetElement[i] = myObj.nextInt();
        }
        
        int address = calculateAddress(dimensions, baseAddress, elementSize, upperBounds, targetElement);
        System.out.println("The exact address of the target element is: " + address);
    }
    
    public static int calculateAddress(int dimensions, int baseAddress, int elementSize, int[] upperBounds, int[] targetElement) {
        int address = baseAddress;
        int[] coefficients = new int[dimensions];
        coefficients[dimensions - 1] = 1;
        
        for (int i = dimensions - 2; i >= 0; i--) {
            coefficients[i] = coefficients[i + 1] * upperBounds[i + 1];
        }
        
        for (int i = 0; i < dimensions; i++) {
            address += targetElement[i] * coefficients[i] * elementSize;
        }
        
        return address;
    }
}
