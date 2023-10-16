package Assignment10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        // Input student data
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            System.out.print("Enter student score: ");
            int score = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            students.add(new Student(name, score));
        }

        // Calculate grades and display results
        for (Student student : students) {
            String grade = calculateGrade(student.getScore());
            System.out.println(student.getName() + ": " + grade);
        }
    }

    public static String calculateGrade(int score) {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
