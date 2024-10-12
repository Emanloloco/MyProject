package employee.payroll.system;
import java.util.Scanner;
import Classes.Employee1;
import Classes.Employee2;

public class EmployeePayrollSystem {
    public static void main(String[] args) {
        Employee1 ee1 = new Employee1("E001", "Alice Go", 20, 200);
        Employee2 ee2 = new Employee2("E002", "Bob Hann", 30, 150);
        
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please choose which employee would you like to calculate the salary");
        System.out.println("Employee 1 \nEmployee 2 ");
        String input = myObj.nextLine();
        
        switch(input) {
            case "1":
                System.out.println();
                System.out.print(ee1.calculateSalary());
                break;
                
            case "2":
                System.out.println();
                System.out.print(ee2.calculateSalary());
                break;
        }
    }  
}
