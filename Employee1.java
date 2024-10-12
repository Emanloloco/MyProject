package Classes;

public class Employee1 {
    String ID;
    String Name;
    double Wage;
    double HoursWorked;
    
    // Constructor
    public Employee1(String id, String name, double wage, double hoursWorked) {
        this.ID = id;
        this.Name = name;
        this.Wage = wage;
        this.HoursWorked = hoursWorked;
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
