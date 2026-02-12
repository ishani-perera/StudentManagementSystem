// Student.java
public class Student {
    private String studentId;
    private String name;
    private double marks;
    private double average;
    private String grade;

    // Constructor
    public Student(String studentId, String name, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.marks = marks;
        calculateAverage();
        calculateGrade();
    }

    // Getters
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

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double marks) {
        this.marks = marks;
        calculateAverage();
        calculateGrade();
    }

    // Calculate average
    private void calculateAverage() {
        this.average = marks; // For now, single subject
    }

    // Calculate grade
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
