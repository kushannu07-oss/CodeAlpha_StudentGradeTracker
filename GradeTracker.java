import java.util.ArrayList;
import java.util.Scanner;

public class GradeTracker {

    public static void main(String[] args) {
        // Create a Scanner to read keyboard input
        Scanner scanner = new Scanner(System.in);

        // Create an ArrayList to store the grades
        ArrayList<Double> grades = new ArrayList<>();

        System.out.println("--- Welcome to the Student Grade Tracker ---");
        System.out.println("Enter student grades one by one.");
        System.out.println("Type -1 when you are finished entering grades.\n");

        while (true) {
            System.out.print("Enter a grade: ");
            double grade = scanner.nextDouble();

            if (grade == -1) {
                break;
            }

            if (grade < 0 || grade > 100) {
                System.out.println("Please enter a valid grade between 0 and 100.");
            } else {
                grades.add(grade);
            }
        }

        if (grades.isEmpty()) {
            System.out.println("No grades were entered. Exiting program.");
        } else {

            double sum = 0;
            double highest = grades.get(0); // Assume first grade is highest initially
            double lowest = grades.get(0);  // Assume first grade is lowest initially

            for (double currentGrade : grades) {
                sum = sum + currentGrade; // Add to total sum

                if (currentGrade > highest) {
                    highest = currentGrade; // Found a new highest
                }

                if (currentGrade < lowest) {
                    lowest = currentGrade; // Found a new lowest
                }
            }

            double average = sum / grades.size();

            // 4. Display the Summary Report
            System.out.println("\n--- Summary Report ---");
            System.out.println("Total Students: " + grades.size());
            System.out.println("Average Grade: " + average);
            System.out.println("Highest Grade: " + highest);
            System.out.println("Lowest Grade: " + lowest);
        }

        // Close the scanner to clean things up
        scanner.close();
    }
}