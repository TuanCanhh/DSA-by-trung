package newpackage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Mylist studentList = new Mylist();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display Students");
            System.out.println("5. Sort Students by Marks (Bubble Sort)");
            System.out.println("6. Sort Students by Marks (Selection Sort)");
            System.out.println("7. Search Student by ID");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter full name: ");
                        String fullName = scanner.nextLine();
                        System.out.print("Enter marks: ");
                        try {
                            double marks = scanner.nextDouble();
                            scanner.nextLine(); // Consume newline
                            studentList.addStudent(new Student(id, fullName, marks));
                            System.out.println("Student added successfully.");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input for marks. Please enter a numeric value.");
                            scanner.nextLine(); // Consume invalid input
                        }
                    }
                    case 2 -> {
                        System.out.print("Enter ID to edit: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter new full name: ");
                        String fullName = scanner.nextLine();
                        System.out.print("Enter new marks: ");
                        try {
                            double marks = scanner.nextDouble();
                            scanner.nextLine(); // Consume newline
                            studentList.editStudent(id, fullName, marks);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input for marks. Please enter a numeric value.");
                            scanner.nextLine(); // Consume invalid input
                        }
                    }
                    case 3 -> {
                        System.out.print("Enter ID to delete: ");
                        String id = scanner.nextLine();
                        studentList.deleteStudent(id);
                    }
                    case 4 -> studentList.displayStudents();
                    case 5 -> {
                        studentList.sortStudents(); // Bubble Sort
                        System.out.println("Students sorted by marks using Bubble Sort.");
                    }
                    case 6 -> {
                        studentList.selectionSortStudents(); // Selection Sort
                        System.out.println("Students sorted by marks using Selection Sort.");
                    }
                    case 7 -> {
                        System.out.print("Enter ID to search: ");
                        String id = scanner.nextLine();
                        Student foundStudent = studentList.searchStudent(id);
                        if (foundStudent != null) {
                            System.out.println("Found: " + foundStudent);
                        } else {
                            System.out.println("Student not found.");
                        }
                    }
                    case 8 -> {
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Invalid choice. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 8.");
                scanner.nextLine(); // Consume invalid input
            }
        }
    }
}
