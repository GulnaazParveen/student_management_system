package mypackage1;
import java.util.Scanner;
import java.util.UUID;
import java.util.*;
import mypackage1.model.Student;
import mypackage1.service.StudentService;
import mypackage1.service.StudentServiceImpl;

public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentServiceImpl();
        Scanner scanner = new Scanner(System.in);
        while(true){
             System.out.println("1. Add | 2. View | 3. Delete | 4. Exit");
             System.out.println("enter your choice:");
             int choice=scanner.nextInt();
             scanner.nextLine();
             switch (choice) {
                case 1:
                    service.addStudent(new Student("Dildar", 22, UUID.randomUUID().toString(), "B", "Java", 2025, 10000, "Delhi", 1234567890));
                    service.addStudent(new Student("Gulnaaz", 22, UUID.randomUUID().toString(), "B", "Java", 2025, 10000,
                            "Delhi", 1234567890));
                    break;
                case 2:
                    System.out.println("Here is list of all students:");
                    for (Student s : service.getAllStudents()) {
                        System.out.println(s);
                    }
                break;
                case 3:
                    System.out.println("Enter student ID to view:");
                    String id = scanner.next();
                    Student student = service.findStudentById(id);
                    if(student != null){
                        System.out.println("Student found: " + student.toString());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                   System.out.println("Enter student ID to delete:");
                   String deleteId = scanner.next();
                     service.deleteStudent(deleteId);
                break;
                case 5:
                    System.out.println("Exiting... Bye!");
                    scanner.close();
                    System.exit(0); 
                break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                 break;
             }
        }
    }
}
