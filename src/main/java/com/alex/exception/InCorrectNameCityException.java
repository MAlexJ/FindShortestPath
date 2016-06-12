package com.alex.exception;

/**
 * Created by malex on 07.06.16.
 */
public class InCorrectNameCityException extends AppException {

    public InCorrectNameCityException() {
    }

    public InCorrectNameCityException(String message) {
        super(message);
    }

    public InCorrectNameCityException(String message, Throwable cause) {
        super(message, cause);
    }
}
