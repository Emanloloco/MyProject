package employee.payroll.system;
import java.util.Scanner;
import Classes.Employee1;
import Classes.Employee2;

public class EmployeePayrollSystem {
    public static void main(String[] args) {
        Employee1 ee1 = new Employee1("E001", "Alice Go", 20, 200);
        Employee2 ee2 = new Employee2("E002", "Bob Hann", 30, 150);
        
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please choose which employee information you would like to view");
        System.out.println("Alice Go \nBob Hann");
        String input = myObj.nextLine();
        System.out.println();
        
        if (input.equalsIgnoreCase("Alice Go")) {
            System.out.println(ee1.displayEmployeeDetails(160));
            System.out.println("Would you like to calculate the salary? YES/NO");
            String input2 = myObj.nextLine();
            System.out.println();
                if (input2.equalsIgnoreCase("YES")) {
                    System.out.print("Salary: " + ee1.calculateSalary(160));
                } 
                else {
                    System.out.println("Okay! The program will be terminated");
                }
        }
                
        if (input.equalsIgnoreCase("Bob Hann")) {
            System.out.println(ee2.displayEmployeeDetails(170));
            System.out.println("Would you like to calculate the salary? YES/NO");
            String input3 = myObj.nextLine();
            System.out.println();
                if (input3.equalsIgnoreCase("YES")) {
                    System.out.print("Salary: " + ee2.calculateSalary(170));
                } 
                else {
                    System.out.println("Okay! The program will be terminated");
                }
        }
    }  
}
