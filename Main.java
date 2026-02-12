// Main.java
// This is the driver class for the Student Management System
// It handles user input, menu, and connects the StudentManager and Student classes

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);
        manager.loadFromFile("students.txt"); // Load previous data if exists

        while (true) {
            // Display main menu
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Save to File");
            System.out.println("6. Load from File");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    // -------------------------------
                    // ADD STUDENT
                    // -------------------------------
                    String id;
                    while (true) {
                        // Validate Student ID: must be numbers only
                        System.out.print("Enter Student ID (numbers only): ");
                        id = sc.nextLine();
                        if (StudentManager.isValidId(id)) break;
                        System.out.println("Invalid ID! Numbers only.");
                    }

                    String name;
                    // Validate Name: letters only
                    while (true) {
                        System.out.print("Enter Name (letters only): ");
                        name = sc.nextLine();
                        if (StudentManager.isValidName(name)) break;
                        System.out.println("Invalid Name! Letters only.");
                    }

                    String marksStr;
                    double marks;
                    // Validate Marks: must be a number between 0-100
                    while (true) {
                        System.out.print("Enter Marks (numbers only): ");
                        marksStr = sc.nextLine();
                        if (StudentManager.isValidMarks(marksStr)) {
                            marks = Double.parseDouble(marksStr);
                            break;
                        }
                        System.out.println("Invalid Marks! Numbers only.");
                    }

                    // Create a new Student object and add it to manager
                    manager.addStudent(new Student(id, name, marks));
                    break;

                case "2":
                    // -------------------------------
                    // VIEW ALL STUDENTS
                    // -------------------------------
                    manager.displayStudents();
                    break;

                case "3":
                     // -------------------------------
                    // SEARCH STUDENT BY ID
                    // -------------------------------
                    System.out.print("Enter Student ID to search: ");
                    String searchId = sc.nextLine();
                    manager.searchStudent(searchId);
                    break;

                case "4":
                    // -------------------------------
                    // DELETE STUDENT BY ID
                    // -------------------------------
                    System.out.print("Enter Student ID to delete: ");
                    String delId = sc.nextLine();
                    manager.deleteStudent(delId);
                    break;

                case "5":
                    // -------------------------------
                    // SAVE STUDENT DATA TO FILE
                    // -------------------------------
                    manager.saveToFile("students.txt");
                    break;

                case "6":
                    // -------------------------------
                    // LOAD STUDENT DATA FROM FILE
                    // -------------------------------
                    manager.loadFromFile("students.txt");
                    break;

                case "7":
                    // -------------------------------
                    // EXIT PROGRAM
                    // -------------------------------
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    // -------------------------------
                    // INVALID CHOICE
                    // -------------------------------
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
