package com.alex.exception;

/**
 * Created by malex on 07.06.16.
 */
public class InCorrectCityException extends RuntimeException {
    public InCorrectCityException() {
    }

    public InCorrectCityException(String message) {
        super(message);
    }

    public InCorrectCityException(String message, Throwable cause) {
        super(message, cause);
    }
}
