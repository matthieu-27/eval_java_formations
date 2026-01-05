package Exceptions;

import java.sql.SQLException;

public class UnknownCourseException extends SQLException {
    public UnknownCourseException(String s) {
        super(s);
    }
}
