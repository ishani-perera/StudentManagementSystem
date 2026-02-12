// Student.java
// This class represents a Student entity in the system.
// It contains student details and logic for calculating average and grade.

public class Student {
    // Private variables (Encapsulation)
    // These fields store student information
    private String studentId;
    private String name;
    Private double marks;
    private double average;
    private String grade;


    // Constructor
    // Initializes student object with ID, name, and marks
    // Automatically calculates average and grade when object is created

    public Student(String studentId, String name, double marks) {
        this.studentId=studentID;
        this.name=name;
        this.marks=marks;
        // Calculate derived values
        calculateAverage();
        calculateGrade();
    }

    // ---------------------------
    // Getter Methods
    // Used to access private variables
    // ---------------------------
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public double getAverage() {
        return average;
    }

    public String getGrade() {
        return grade;
    }

    // ---------------------------
    // Setter Methods
    // Used to modify student details
    // ---------------------------


    // Update student name
    public void setName(String name) {
        this.name = name;
    }

    // Update student marks
    // Recalculate average and grade after updating marks
    public void setMarks(double marks) {
        this.marks = marks;
        calculateAverage();
        calculateGrade();
    }

    // Calculate average
    private void calculateAverage() {
        this.average = marks; // For now, single subject
    }

    // Calculate grade based on average
    // Grade criteria:
    // 75+  = A
    // 65-74 = B
    // 55-64 = C
    // 40-54 = D
    // Below 40 = F
    private void calculateGrade() {
        if (average >= 75) grade = "A";
        else if (average >= 65) grade = "B";
        else if (average >= 55) grade = "C";
        else if (average >= 40) grade = "D";
        else grade = "F";
    }

    @Override
    public String toString() {
        return "ID: " + studentId +
               ", Name: " + name +
               ", Marks: " + marks +
               ", Average: " + average +
               ", Grade: " + grade;
    }
}
