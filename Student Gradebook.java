import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GradeBook {
    private Map<String, Double> grades;

    public GradeBook() {
        grades = new HashMap<>();
    }

    public void addGrade(String studentName, double grade) {
        grades.put(studentName, grade);
    }

    public double getGrade(String studentName) {
        return grades.getOrDefault(studentName, -1.0);
    }

    public void printGradeBook() {
        if (grades.isEmpty()) {
            System.out.println("Grade book is empty.");
        } else {
            System.out.println("Grade Book:");
            for (Map.Entry<String, Double> entry : grades.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        GradeBook gradeBook = new GradeBook();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Grade Book!");
        while (true) {
            System.out.println("\n1. Add a grade");
            System.out.println("2. Get a grade");
            System.out.println("3. Print grade book");
            System.out.println("4. Exit");

            System.out.print("\nEnter your choice (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter grade: ");
                    double grade = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    gradeBook.addGrade(name, grade);
                    System.out.println("Grade added successfully!");
                    break;
                case 2:
                    System.out.print("Enter student name: ");
                    name = scanner.nextLine();
                    double studentGrade = gradeBook.getGrade(name);
                    if (studentGrade == -1.0) {
                        System.out.println("No grade found for the student.");
                    } else {
                        System.out.println("Grade for " + name + ": " + studentGrade);
                    }
                    break;
                case 3:
                    gradeBook.printGradeBook();
                    break;
                case 4:
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);
                default:
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
