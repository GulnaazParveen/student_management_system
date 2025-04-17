package mypackage1.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mypackage1.exception.InvalidStudentDataException;
import mypackage1.exception.StudentNotFoundException;
import mypackage1.model.Student;

public class StudentServiceImpl implements StudentService {
    private List<Student>students=new ArrayList<>();

    public void addStudent(Student student) throws InvalidStudentDataException {
      if (student.getName().trim().isEmpty()) {
        throw new InvalidStudentDataException("Name cannot be empty!");
      }
        if (student.getAge() < 0) {
            throw new InvalidStudentDataException("Age cannot be negative!");
        }
        if (student.getStudentId().trim().isEmpty()) {
            throw new InvalidStudentDataException("Student ID cannot be empty!");
        }
        if (student.getGrade().trim().isEmpty()) {
            throw new InvalidStudentDataException("Grade cannot be empty!");
        }
        if (student.getCourse().trim().isEmpty()) {
            throw new InvalidStudentDataException("Course cannot be empty!");
        }
        if (student.getYearOfStudy() > 2025) {
            throw new InvalidStudentDataException("Year of study cannot be greater than 2025!");
        }
        if (student.getCourseFee() < 0) {
            throw new InvalidStudentDataException("Course fee cannot be negative!");
        }
        if (student.getAddress().trim().isEmpty()) {
            throw new InvalidStudentDataException("Address cannot be empty!");
        }
        if (String.valueOf(student.getPhoneNumber()).length() != 10) {
            throw new InvalidStudentDataException("Phone number must be 10 digits!");
        }
        students.add(student);
      
    }

    public List<Student> getAllStudents(){
        return students;
    }
    public Student findStudentById(String id) throws StudentNotFoundException{
        for(Student student:students){
            if(student.getStudentId().equals(id)){
                return student;
            }
        }
        throw new StudentNotFoundException("Student with ID " + id + " not found.");
    }
    public void updateStudent(String id, Scanner scanner) throws InvalidStudentDataException, StudentNotFoundException {
        boolean found = false;
        for(int i=0;i<students.size();i++){
            if (students.get(i).getStudentId().equals(id)){
                found = true;
               System.out.println("What do you want to update?");
               System.out.println("1. Name | 2. Age | 3. Course | 4. Address | 5. Phone Number |6. grade | 7. Exit" );
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Enter new name: ");
                        String name = scanner.nextLine();
                        if(name.trim().isEmpty()){
                            throw new InvalidStudentDataException("Name cannot be empty!");
                        }
                        students.get(i).setName(name);
                        break;
                    case 2:
                        System.out.println("Enter new age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine(); 
                        if(age<0){
                            throw new InvalidStudentDataException("Age cannot be negative!");
                        }
                        students.get(i).setAge(age);
                        break;
                    case 3:
                        System.out.println("Enter new course: ");
                        String course = scanner.nextLine();
                        if(course.trim().isEmpty()){
                            throw new InvalidStudentDataException("Course cannot be empty!");
                        }
                        students.get(i).setCourse(course);
                        break;
                    case 4:
                        System.out.println("Enter new address: ");
                        String address = scanner.nextLine();
                        if(address.trim().isEmpty()){
                            throw new InvalidStudentDataException("Address cannot be empty!");
                        }
                        students.get(i).setAddress(address);
                        break;
                    case 5:
                      System.out.println("Enter new phone number: ");
                        int phoneNumber = scanner.nextInt();
                        scanner.nextLine(); 
                        if(String.valueOf(phoneNumber).length()!=10){
                            throw new InvalidStudentDataException("Phone number must be 10 digits!");
                        }
                        students.get(i).setPhoneNumber(phoneNumber);
                        break;
                    case 6:
                        System.out.println("Enter new grade: ");
                        String grade = scanner.nextLine();
                        if(grade.trim().isEmpty()){
                            throw new InvalidStudentDataException("Grade cannot be empty!");
                        }
                        students.get(i).setGrade(grade);
                        break;
                    case 7:
                        System.out.println("Exiting update menu.");
                        return;
                    default:
                        System.out.println("Invalid choice!");
                        break;
                }

           }
        }
        if (!found) {
            throw new StudentNotFoundException("Student with ID " + id + " not found.");
        }
    }
    public void deleteStudent(String id) throws StudentNotFoundException{
        for(int i=0;i<students.size();i++){
            if(students.get(i).getStudentId().equals(id)){
                students.remove(i);
                return;
            }
        }
        throw new StudentNotFoundException("Student with ID " + id + " not found.");
    }
    
}
