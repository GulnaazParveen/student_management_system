package mypackage1.service;
import java.util.ArrayList;
import java.util.List;

import mypackage1.model.Student;

public class StudentServiceImpl implements StudentService {
    private List<Student>students=new ArrayList<>();

    public void addStudent(Student student){
       students.add(student);
    }

    public List<Student> getAllStudents(){
        return students;
    }
    public Student findStudentById(String id){
        for(Student student:students){
            if(student.getStudentId().equals(id)){
                return student;
            }
        }
        return null;
    }
    public void updateStudent(String id, Student student){
        for(int i=0;i<students.size();i++){
            if(students.get(i).getStudentId().equals(id)){
                students.set(i,student);
                return;
            }
        }
    }
    public void deleteStudent(String id){
        for(int i=0;i<students.size();i++){
            if(students.get(i).getStudentId().equals(id)){
                students.remove(i);
                return;
            }
        }
    }
    
}
