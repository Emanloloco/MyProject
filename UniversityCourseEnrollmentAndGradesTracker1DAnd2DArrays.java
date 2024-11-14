package university.course.enrollment.and.grades.tracker.pkg1d.and.pkg2d.arrays;
import java.util.Scanner;

public class UniversityCourseEnrollmentAndGradesTracker1DAnd2DArrays {

    public static void main(String[] args) {

        int studentsNum = 5;
        int subjectsNum = 3;

        // Store students' names in array.
        String[] myStudents = new String[studentsNum];

        // Store students' grades in array.
        double[][] myStudentsGrades = new double[studentsNum][subjectsNum];

        // Create a variable for array length.
        int mySubjectsGradesRow = myStudentsGrades.length;
        
        // Create a Scanner object to take input from the user
        Scanner myObj = new Scanner(System.in);

        // Arrays to store the average grade for each student.
        double[] averageGrade = new double[myStudentsGrades.length];

        // Get the average grade per student.
        for (int i = 0; i < mySubjectsGradesRow; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            int mySubjectsGradesColumn = myStudentsGrades[i].length;
            int totalGrades = 0;
            myStudents[i] = myObj.nextLine();

            // Get the sum of grades per student.
            for (int j = 0; j < mySubjectsGradesColumn; j++) {
                System.out.print("Enter the student's grade for this subject " + (j + 1) + " for " + myStudents[i] + ": ");
                double subjectGrades = myStudentsGrades[i][j] = myObj.nextDouble();
                totalGrades += subjectGrades;
            }
            myObj.nextLine();
            System.out.println();
            
            // Formula to get the average grade.
            averageGrade[i] = (double) totalGrades / mySubjectsGradesColumn;
        }
        
        // Display students name and average grade.
        for (int k = 0; k < mySubjectsGradesRow; k++) {
            System.out.println("The average grade of " + myStudents[k] + " is " + String.format("%.2f",averageGrade[k]));
        }
    }
}
