import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Student {
    private String name;
    private HashMap<String, Double> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new HashMap<>();
    }

    public void addGrade(String subject, double grade) {
        grades.put(subject, grade);
    }

    public double getAverageGrade() {
        double total = 0;
        for (double grade : grades.values()) {
            total += grade;
        }
        return total / grades.size();
    }

    public HashMap<String, Double> getGrades() {
        return grades;
    }

    public String getName() {
        return name;
    }
}

public class GradeTracker {
    private ArrayList<Student> students;

    public GradeTracker() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayGrades() {
        for (Student student : students) {
            System.out.println("Grades for " + student.getName() + ": " + student.getGrades());
        }
    }

    public void displayAverages() {
        for (Student student : students) {
            System.out.println(student.getName() + "'s Average: " + student.getAverageGrade());
        }
    }

    public static void main(String[] args) {
        GradeTracker tracker = new GradeTracker();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine(); // Clear the newline character

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Enter student name: ");
            String name = scanner.nextLine();
            Student student = new Student(name);

            System.out.println("Enter number of subjects: ");
            int numberOfSubjects = scanner.nextInt();
            scanner.nextLine(); // Clear the newline character

            for (int j = 0; j < numberOfSubjects; j++) {
                System.out.println("Enter subject name: ");
                String subject = scanner.nextLine();

                System.out.println("Enter grade: ");
                double grade = scanner.nextDouble();
                scanner.nextLine(); // Clear the newline character

                student.addGrade(subject, grade);
            }

            tracker.addStudent(student);
        }

        tracker.displayGrades();
        tracker.displayAverages();
        scanner.close();
    }
}
