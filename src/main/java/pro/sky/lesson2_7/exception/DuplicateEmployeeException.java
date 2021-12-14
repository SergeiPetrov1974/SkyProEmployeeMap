package pro.sky.lesson2_7.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class DuplicateEmployeeException extends RuntimeException {
    public DuplicateEmployeeException(String s) {
        System.out.println(s);
    }
}