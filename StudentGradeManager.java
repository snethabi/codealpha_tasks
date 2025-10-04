import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private ArrayList<Integer> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public ArrayList<Integer> getGrades() {
        return grades;
    }

    public double getAverage() {
        if (grades.isEmpty()) return 0;
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public int getHighest() {
        if (grades.isEmpty()) return 0;
        int highest = grades.get(0);
        for (int grade : grades) {
            if (grade > highest) highest = grade;
        }
        return highest;
    }

    public int getLowest() {
        if (grades.isEmpty()) return 0;
        int lowest = grades.get(0);
        for (int grade : grades) {
            if (grade < lowest) lowest = grade;
        }
        return lowest;
    }
}

public class StudentGradeManager {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        System.out.println("==== Student Grade Management System ====");
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student and Grades");
            System.out.println("2. Display Summary Report");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displaySummary();
                    break;
                case 3:
                    System.out.println("Exiting program. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        Student student = new Student(name);

        System.out.print("Enter number of grades to input: ");
        int numGrades = getIntInput();

        for (int i = 0; i < numGrades; i++) {
            System.out.print("Enter grade #" + (i + 1) + ": ");
            int grade = getIntInput();
            student.addGrade(grade);
        }

        students.add(student);
        System.out.println("Student added successfully!");
    }

    private static void displaySummary() {
        if (students.isEmpty()) {
            System.out.println("No students available to display.");
            return;
        }

        System.out.println("\n==== Summary Report ====");
        for (Student student : students) {
            System.out.println("Name: " + student.getName());
            System.out.println("Grades: " + student.getGrades());
            System.out.printf("Average: %.2f\n", student.getAverage());
            System.out.println("Highest: " + student.getHighest());
            System.out.println("Lowest: " + student.getLowest());
            System.out.println("-----------------------------");
        }
    }

    private static int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter a number: ");
            scanner.next(); // clear invalid input
        }
        return scanner.nextInt();
    }
}
