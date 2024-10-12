package Classes;

public class Employee2 {
    String ID;
    String Name;
    double Wage;
    double HoursWorked;
    
    // Constructor
    public Employee2(String id2, String name2, double wage2, double hoursWorked2) {
        this.ID = id2;
        this.Name = name2;
        this.Wage = wage2;
        this.HoursWorked = hoursWorked2;
    }
    public double calculateSalary(){
        double salary = 0;
        String ID;
        String Name;
        double Wage = 0;
        double HoursWorked = 0;
        salary = Wage * HoursWorked;
        return salary;
    }
}
