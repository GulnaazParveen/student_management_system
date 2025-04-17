package mypackage1;

import java.util.*;
import mypackage1.model.Student;
import mypackage1.service.StudentService;
import mypackage1.service.StudentServiceImpl;
import mypackage1.exception.InvalidStudentDataException;
import mypackage1.exception.StudentNotFoundException;

public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentServiceImpl();
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("1. Add | 2. View | 3.FindStudentById | 4. Update | 5. Delete |6.Exit" );
            System.out.println("enter your choice:");
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue; 
            } catch (NoSuchElementException e) {
                System.out.println("No input available. Exiting program.");
                break;
            }
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter student ID: ");
                        String studentId = scanner.nextLine();
                        System.out.print("Enter course: ");
                        String course = scanner.nextLine();
                        System.out.print("Enter year of study: ");
                        int yearOfStudy = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter course fee: ");
                        int courseFee = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter address: ");
                        String address = scanner.nextLine();
                        System.out.print("Enter phone number: ");
                        int phoneNumber = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Enter grade: ");
                        String grade = scanner.nextLine();
                        Student student = new Student(name, age, studentId, grade, course, yearOfStudy, courseFee,
                                address, phoneNumber);
                        service.addStudent(student);

                        System.out.println("Student added successfully.");
                    } catch (InvalidStudentDataException e) {
                        // TODO: handle exception
                        System.out.println("Error: " + e.getMessage());
                    }
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
                   
                   try {
                     Student student = service.findStudentById(id);
                        System.out.println("Student found: " + student);
                   } catch (StudentNotFoundException e) {
                  
                    System.out.println("student not found with id: " + id);
                    System.out.println(e.getMessage());
                   }
                    break;
                case 4:
                   System.out.println("Enter student ID to Update");
                    String updateId="";
                    try {
                         updateId = scanner.next();
                        service.updateStudent(updateId, scanner);
                        System.out.println("Student updated successfully.");
                    } catch (StudentNotFoundException e) {
                        
                        System.out.println("student not found with id: " + updateId);
                        System.out.println(e.getMessage());
                    }catch (InvalidStudentDataException e) {
                        System.out.println("Invalid data provided during update: ");
                       System.out.println(e.getMessage());
                  }
                 break;
                case 5:
                    System.out.println("Enter student ID to delete:");
                    String deleteId = scanner.next();
                   try {
                       service.deleteStudent(deleteId);
                        System.out.println("Student deleted successfully.");
                   } catch (StudentNotFoundException e) {
                    System.out.println("student not found with id: " + deleteId);
                    System.out.println(e.getMessage());
                   } 
                    break;
                case 6:
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
