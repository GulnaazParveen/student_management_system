package mypackage1.exception;
import java.lang.Exception;
public class InvalidStudentDataException extends Exception {
    public InvalidStudentDataException(String message) {
        super(message);
    }
}
