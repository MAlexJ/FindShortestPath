package com.alex.exception;

/**
 * Created by malex on 12.06.2016.
 */
public class InCorrectCostException extends AppException {
    public InCorrectCostException() {
    }

    public InCorrectCostException(String message) {
        super(message);
    }

    public InCorrectCostException(String message, Throwable cause) {
        super(message, cause);
    }
}
