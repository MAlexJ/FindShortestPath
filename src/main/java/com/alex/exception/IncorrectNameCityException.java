package com.alex.exception;

/**
 * Created by malex on 07.06.16.
 */
public class IncorrectNameCityException extends AppException {

    public IncorrectNameCityException() {
    }

    public IncorrectNameCityException(String message) {
        super(message);
    }

    public IncorrectNameCityException(String message, Throwable cause) {
        super(message, cause);
    }
}
