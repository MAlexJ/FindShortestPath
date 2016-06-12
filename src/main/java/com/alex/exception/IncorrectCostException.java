package com.alex.exception;

/**
 * Created by malex on 12.06.2016.
 */
public class IncorrectCostException extends AppException {
    public IncorrectCostException() {
    }

    public IncorrectCostException(String message) {
        super(message);
    }

    public IncorrectCostException(String message, Throwable cause) {
        super(message, cause);
    }
}
