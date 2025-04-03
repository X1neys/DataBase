import java.util.List;
import java.util.Scanner;

public class AddRecordOptimize {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseManager dbManager = new DatabaseManager();

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Add new student");
            System.out.println("2. Show all records");
            System.out.println("3. Exit the program");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.println("\nAdd a new student:");
                System.out.print("Enter Student ID: ");
                String studentId = scanner.nextLine();
                System.out.print("Enter Last Name: ");
                String lname = scanner.nextLine();
                System.out.print("Enter First Name: ");
                String fname = scanner.nextLine();
                System.out.print("Enter Middle Initial: ");
                String mi = scanner.nextLine();

                Student newStudent = new Student(studentId, lname, fname, mi);
                boolean isAdded = dbManager.addStudent(newStudent);
                if (isAdded) {
                    System.out.println("Successfully added the student: " + newStudent);
                } else {
                    System.out.println("Failed to add the student.");
                }
            } else if (choice.equals("2")) {
                List<Student> students = dbManager.getAllStudents();
                if (students.isEmpty()) {
                    System.out.println("No records found.");
                } else {
                    for (Student student : students) {
                        System.out.println(student);
                    }
                }
            } else if (choice.equals("3")) {
                System.out.println("Exiting the program.");
                break;
            } else {
                System.out.println("Invalid input. Please select a valid option (1, 2, or 3).");
            }
            System.out.println();
        }
        scanner.close();
    }
}
