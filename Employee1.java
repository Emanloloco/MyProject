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
    public double calculateSalary(double hoursWorked){
        double salary = 0;
        salary = Wage * hoursWorked;
        System.out.println("ID: " + ID + "\nName: " + Name + "\nWage: " + Wage + "\nHoursWorked: " + hoursWorked);
        return salary;
    }
    
    public String displayEmployeeDetails(double hoursWorked) {
        return "ID: " + ID + "\nName: " + Name + "\nWage: " + Wage + "\nHoursWorked: " + hoursWorked;
    }
}
