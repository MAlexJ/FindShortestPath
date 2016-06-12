package com.alex.exception;

/**
 * Created by malex on 07.06.16.
 */
public class IncorrectNumberCityException extends AppException {

    public IncorrectNumberCityException() {
    }

    public IncorrectNumberCityException(String message) {
        super(message);
    }

    public IncorrectNumberCityException(String message, Throwable cause) {
        super(message, cause);
    }
}
