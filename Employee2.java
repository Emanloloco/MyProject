package Classes;

public class Employee2 {
    String ID2;
    String Name2;
    double Wage2;
    double HoursWorked2;
    
    // Constructor
    public Employee2(String id2, String name2, double wage2, double hoursWorked2) {
        this.ID2 = id2;
        this.Name2 = name2;
        this.Wage2 = wage2;
        this.HoursWorked2 = hoursWorked2;
    }
    
    public String displayEmployeeDetails(double hoursWorked2) {
        return "ID:" + ID2 + "\nName: " + Name2 + "\nWage: " + Wage2 + "\nHoursWorked: " + hoursWorked2;
    }
    
    public double calculateSalary(double hoursWorked2){
        double salary = 0;
        salary = Wage2 * hoursWorked2;
        System.out.println("ID: " + ID2 + "\nName: " + Name2 + "\nWage: " + Wage2 + "\nHoursWorked: " + hoursWorked2);
        return salary;
    }
}
