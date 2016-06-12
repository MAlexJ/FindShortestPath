package com.alex.exception;

/**
 * Created by malex on 12.06.16.
 */
public class IncorrectNumberTestsException extends AppException {
    public IncorrectNumberTestsException() {
    }

    public IncorrectNumberTestsException(String message) {
        super(message);
    }

    public IncorrectNumberTestsException(String message, Throwable cause) {
        super(message, cause);
    }
}
