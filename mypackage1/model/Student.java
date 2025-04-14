package mypackage1.model;

public class Student {
    private String name;
    private int age;
    private String studentId;
    private String grade;
    private String course;
    private int yearOfStudy;
    private int courseFee;
    private String address;
    private int  phoneNumber;
    
    // constructor
    public Student(String name, int age, String studentId, String grade, String course, int yearOfStudy, int courseFee, String address, int phoneNumber) {       
        this.name = name;
        this.age = age;
        this.studentId = studentId;
        this.grade = grade; 
        this.course = course;
        this.yearOfStudy = yearOfStudy;
        this.courseFee = courseFee;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getStudentId() {
        return studentId;
    }
    public String getGrade(){
        return grade;
    }
    
    public String getCourse() {
        return course;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public int getCourseFee() {
        return courseFee;
    }

    public String getAddress() {
        return address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String toString(){
      return name + " | " + studentId + " | "  + grade + " | " + course ;
    }
}
