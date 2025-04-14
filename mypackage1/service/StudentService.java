package mypackage1.service;
import mypackage1.model.Student;
import java.util.List;

public interface StudentService {

  void addStudent(Student student);
  List<Student> getAllStudents();
  Student findStudentById(String id);
  void updateStudent(String id, Student student);
  void deleteStudent(String id);
} 
