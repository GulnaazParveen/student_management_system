package mypackage1.service;
import mypackage1.exception.InvalidStudentDataException;
import mypackage1.exception.StudentNotFoundException;
import mypackage1.model.Student;
import java.util.List;
import java.util.Scanner;

public interface StudentService {

void addStudent(Student student) throws InvalidStudentDataException;
  List<Student> getAllStudents();
  Student findStudentById(String id) throws StudentNotFoundException;
 void updateStudent(String id, Scanner scanner) throws InvalidStudentDataException, StudentNotFoundException;
  void deleteStudent(String id) throws StudentNotFoundException;
} 
