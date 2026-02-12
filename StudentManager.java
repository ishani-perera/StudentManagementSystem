// StudentManager.java
// This class manages all student-related operations such as
// adding, searching, deleting, saving, and loading students.

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class StudentManager {
    // ArrayList to store Student objects
    private ArrayList<Student> students;


    // Constructor
    // Initializes the student list when StudentManager object is created
    public StudentManager() {
        students = new ArrayList<>();
    }

    // ---------------------------
    // Add Student
    // ---------------------------
    // Adds a new student to the list
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    // ---------------------------
    // Display All Students
    // ---------------------------
    // Displays all students in the system
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student s : students) {
                System.out.println(s); // Calls Student.toString() method
            }
        }
    }

    // ---------------------------
    // Search Student by ID
    // ---------------------------
    // Searches for a student using their ID
    public void searchStudent(String id) {
        for (Student s : students) {
            if (s.getStudentId().equals(id)) {
                System.out.println("Student found: " + s);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // ---------------------------
    // Delete Student by ID
    // ---------------------------
    // Removes a student safely using Iterator to avoid ConcurrentModificationException
    public void deleteStudent(String id) {
        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.getStudentId().equals(id)) {
                iterator.remove(); // Safe removal
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }


    // Save to file
    public void saveToFile(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Student s : students) {
                bw.write(s.getStudentId() + "," + s.getName() + "," + s.getMarks());
                bw.newLine();
            }
            System.out.println("Data saved to file successfully!");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    // Load from file
    public void loadFromFile(String filename) {
        students.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String id = parts[0];
                    String name = parts[1];
                    double marks = Double.parseDouble(parts[2]);
                    students.add(new Student(id, name, marks));
                }
            }
            System.out.println("Data loaded successfully!");
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    // Input validation helpers
    public static boolean isValidId(String id) {
        return id.matches("\\d+"); // Only numbers
    }

    public static boolean isValidName(String name) {
        return name.matches("[a-zA-Z ]+"); // Only letters and spaces
    }

    public static boolean isValidMarks(String marks) {
        return marks.matches("\\d+(\\.\\d+)?"); // Only numbers, can be decimal
    }
}
