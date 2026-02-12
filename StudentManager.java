// StudentManager.java
import java.io.*;
import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    // Add student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    // Display all students
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    // Search student by ID
    public void searchStudent(String id) {
        for (Student s : students) {
            if (s.getStudentId().equals(id)) {
                System.out.println("Student found: " + s);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Delete student by ID
    public void deleteStudent(String id) {
        for (Student s : students) {
            if (s.getStudentId().equals(id)) {
                students.remove(s);
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
